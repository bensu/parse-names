(def project 'parse-names)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "RELEASE"]
                            [adzerk/boot-test "RELEASE" :scope "test"]
                            [adzerk/bootlaces "0.1.13" :scope "test"]
                            [org.clojars.bensu/commons-text "0.1-SNAPSHOT-0"]])

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

(require '[adzerk.boot-test :refer [test]])
(require '[adzerk.bootlaces :refer :all])

(bootlaces! version)
