(def project 'parse-names)
(def version "0.1.1-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "1.7.0"]
                            [org.clojure/clojurescript "1.7.228"]
                            [org.clojars.bensu/commons-text "0.1-SNAPSHOT-0"]
                            [org.clojure/data.json "0.2.6"]
                            [adzerk/bootlaces "0.1.13" :scope "test"]])

(task-options!
 pom {:project     project
      :version     version
      :description ""
      :url         "http://github.com/bensu/parse-names"
      :scm         {:url "https://github.com/bensu/parse-names"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[adzerk.bootlaces :refer :all]
         '[cljs.repl.node :as node])

(bootlaces! version)

(comment
  (deftask node-repl []
    (cljs.repl/repl (node/repl-env :debug-port 5002))
    ))
