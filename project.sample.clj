(defproject sample-project "0.1.0"
  :description "A sample project that uses clj-webdriver with clojure.test for functional tests."
  :dependencies [[clj-webdriver "0.6.0" :exclusions [org.seleniumhq.selenium/selenium-server]]
                 [org.seleniumhq.selenium/selenium-server "2.33.0"]]
  :sauce {:username "helpshift"
          :pass "4c5a333d-92e4-460a-8c16-bed6cb6a8c8e"
          :specs {:testone [["windows8" "chrome" 27]
                            ["windows8" "safari" 5]]}})
