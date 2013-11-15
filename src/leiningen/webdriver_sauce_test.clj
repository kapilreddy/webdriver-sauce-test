(ns leiningen.webdriver-sauce-test
  (:require [leiningen.test :as lt]
            [clj-webdriver.remote.server :refer [new-remote-session]]
            [clj-webdriver.taxi]
            [leiningen.core.eval :as eval]))


(def platform-map {"windows8" "VISTA"
                   "linux" "LINUX"
                   "ie" "internet explorer"})

(defn init-grid
  "Initializes the grid code"
  [port cred spec]
  (new-remote-session {:port port
                       :host cred
                       :existing true}
                      {:capabilities spec}))


(defn webdriver-sauce-test
  "I don't do a lot."
  [{:keys [sauce] :as project} browser-spec & tests]
  (let [set-driver! clj-webdriver.taxi/set-driver!]
    (when sauce ;; @TODO add log for specifying sauce in project.clj
      (let [{:keys [specs username pass driver-ns]} sauce]
        (doseq [[platform browser version] (get specs (keyword browser-spec))]
          (let [spec {"platform" (get platform-map platform)
                      "browserName" browser
                      "version" version}
                [server driver] (init-grid 80
                                           (format "%s:%s@ondemand.saucelabs.com"
                                                   username
                                                   pass)
                                           spec)]
            (println (format "Running tests on %s %s %s" platform browser version))
            (alter-var-root #'clj-webdriver.taxi/set-driver!
                            (constantly (fn [& args]
                                          (set-driver! driver))))
            (apply lt/test project tests)))))))
