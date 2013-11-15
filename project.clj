(defproject me.kapilreddy/webdriver-sauce-test "0.1.0-SNAPSHOT"
  :description "A leiningen plugin for running clj-webdriver clojure.test tests on sauce labs."
  :url "http://github.com/kapilreddy/webdriver-sauce-test"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[clj-webdriver "0.6.0" :exclusions [org.seleniumhq.selenium/selenium-server]]
                 [org.seleniumhq.selenium/selenium-server "2.35.0"]])
