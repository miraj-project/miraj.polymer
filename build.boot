(def +project+ 'miraj.polymer/dom)
(def +version+ "1.8.1-SNAPSHOT")

(set-env!
 ;; :source-paths #{"edn"} ;; "src/test/clj"}
 :resource-paths #{"src/main/clj"} ;;; "resources"
 ;; :resource-paths #{"resources"}
 ;; :target-path "resources/public"
 ;; :asset-paths #{"resources/public"}

 :checkouts '[[miraj/co-dom                  "1.0.0-SNAPSHOT"]
              ;; [miraj/html                    "5.1.0-SNAPSHOT"]
              [miraj/core                    "0.1.0-SNAPSHOT"]
              ]

 :dependencies '[[miraj/co-dom               "1.0.0-SNAPSHOT"]
                 [miraj/core                    "0.1.0-SNAPSHOT"]
                 ;; [miraj/boot-miraj "0.1.0-SNAPSHOT"]
                 ;; [adzerk/boot-cljs "1.7.228-1" :scope "test"]
                 ;; [adzerk/boot-cljs-repl "0.3.0" :scope "test"]

                 ;; testing
                 [miraj/html                    "5.1.0-SNAPSHOT" :scope "test"]
                 [miraj.polymer/iron            "1.2.3-SNAPSHOT" :scope "test"]
                 [miraj.polymer/paper           "1.2.3-SNAPSHOT" :scope "test"]

                 [miraj/boot-miraj           "0.1.0-SNAPSHOT" :scope "test"]
                 [pandeiro/boot-http "0.7.3"           :scope "test"]
                 [samestep/boot-refresh "0.1.0"]
                 [adzerk/boot-test "1.0.7" :scope "test"]])

(require '[miraj.boot-miraj :as miraj]
         '[samestep.boot-refresh :refer [refresh]]
         '[pandeiro.boot-http :as http :refer :all]
         '[adzerk.boot-test :refer [test]])

(task-options!
 repl {:port 8080}
 pom {:project +project+
      :version +version+}
 jar {:manifest {"root" "miraj"}})

(deftask build
  "build"
  []
  (comp (pom)
        (jar)
        (install)
        (target)))

(deftask demos
  "build component demos"
  []
  ;;(set-env! :source-paths #(conj % "demos/clj"))
  (comp
   ;; (build)
   (watch)
   (miraj/compile :pages true :debug true :keep true)
   ;; (miraj/link    :pages true :debug true) ;; :keep true)
   ;; (miraj/demo-page :debug true)
   ;; (cljs)
   ;; (boot/sift :to-resource #{#".*\.cljs\.edn"}) ;; keep main.cljs.edn, produced by (cljs)
   (target   :no-clean   true)))

(deftask dev
  "watch etc."
  []
  (comp (watch)
        (notify :audible true)
        ;;(miraj/compile :libraries true :verbose true)
        (pom)
        (jar)
        (install)))

(deftask install-local
  "Build and install a component library"
  []
  (comp (pom)
        (jar)
        (target)
        (install)))

(deftask run-demos
  "compile, link, serve demos"
  []
  (set-env! :resource-paths #(conj % "demos/clj"))
  (comp
   (build)
   (serve :dir "target")
   (cider)
   (repl)
   ;;(demos)
   (watch)
   (notify :audible true)
   ;; (miraj/compile :pages true :debug true :keep true)
   ;; (miraj/link    :pages true :debug true) ;; :keep true)
   ;; (miraj/demo-page :debug true)
   ;; (cljs-repl)
   ;;(refresh)
   ;; (miraj.boot-miraj/compile :keep true :debug true :pages true)
   ;; (miraj.boot-miraj/link    :debug true :pages true)
   ;; (target) ;; :no-clean true)
   ;; (cljs)
   (target)))
