(def +project+ 'miraj.polymer/dom)
(def +version+ "1.8.1-SNAPSHOT")

(set-env!
 :resource-paths #{"src/main/clj"}

 ;; :checkouts '[[miraj/co-dom                  "1.0.0-SNAPSHOT"]
 ;;              ;; [miraj/html                    "5.1.0-SNAPSHOT"]
 ;;              [miraj/core                    "0.1.0-SNAPSHOT"]
 ;;              ]

 :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"}])

 :dependencies '[[miraj/co-dom               "1.0.0-SNAPSHOT"]

                 ;; testing
                 [miraj/core                    "0.1.0-SNAPSHOT" :scope "test"]
                 [miraj/html                    "5.1.0-SNAPSHOT" :scope "test"]
                 [miraj.polymer/iron            "1.2.3-SNAPSHOT" :scope "test"]
                 [miraj.polymer/paper           "1.2.3-SNAPSHOT" :scope "test"]
                 ;; [miraj/boot-miraj "0.1.0-SNAPSHOT"]
                 ;; [adzerk/boot-cljs "1.7.228-1" :scope "test"]
                 ;; [adzerk/boot-cljs-repl "0.3.0" :scope "test"]


                 [miraj/boot-miraj           "0.1.0-SNAPSHOT" :scope "test"]
                 [pandeiro/boot-http "0.7.3"           :scope "test"]
                 [samestep/boot-refresh "0.1.0" :scope "test"]
                 [adzerk/boot-test "1.0.7" :scope "test"]])

(require '[miraj.boot-miraj :as miraj]
         '[samestep.boot-refresh :refer [refresh]]
         '[pandeiro.boot-http :as http :refer :all]
         '[adzerk.boot-test :refer [test]])

(task-options!
 repl {:port 8080}
 pom {:project +project+
      :version +version+
      :description "Miraj Polymer Helper Element functions"
       :url "https://github.com/mobileink/miraj-project/polymer-dom"
       :scm         {:url "https://github.com/miraj-project/polymer-dom.git"}
       :license     {"EPL" "http://www.eclipse.org/legal/epl-v10.html"}}
 jar {:manifest {"root" "miraj"}})

(deftask build
  "build"
  []
  (comp (pom)
        (jar)
        (install)
        (target)))

(deftask check
  "watch etc. for dev as a checkout"
  []
  (comp (watch)
        (notify :audible true)
        (pom)
        (jar)
        (target)
        (install)))

(deftask systest
  "serve and repl for integration testing; run this, then eval test/system/clj code using cider"
  []
  (set-env! :resource-paths #(conj % "test/system/clj"))
  (comp
   (build)
   (serve :dir "target")
   (cider)
   (repl)
   (watch)
   (notify :audible true)
   (target)))

(deftask utest
  "run unit tests"
  [n namespaces  NS  #{sym}  "test ns"]
  (set-env! :source-paths #(conj % "test/unit/clj"))
  (test :namespaces namespaces))
