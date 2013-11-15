# webdriver-sauce-test

A leiningen plugin for running clj-webdriver clojure.test tests on sauce labs.

## Usage

Put `[webdriver-sauce-test "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your
`:user` profile, or if you are on Leiningen 1.x do `lein plugin install
webdriver-sauce-test 0.1.0-SNAPSHOT`.
or
Put `[webdriver-sauce-test "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.


Refer to project.sample.clj for settings.


    $ lein webdriver-sauce-test {spec} :only sample-project.login-test/login

webdriver-sauce-test uses clojure.test internally. So 'lein test' arguments are valid arguments for webdriver-sauce-test after specifying a spec.

## License

Copyright © 2013 Kapil Reddy

Distributed under the Eclipse Public License, the same as Clojure.
