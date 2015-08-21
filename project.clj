(defproject alpha "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                [ring/ring-core "1.4.0"]]
  :plugins [[lein-ring "0.9.6"]]
  :ring {:handler alpha.core/app
        :resources-war-path "WEB-INF/classes/"})
