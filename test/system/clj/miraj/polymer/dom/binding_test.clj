(ns miraj.polymer.dom.binding-test
  (:require [miraj.core :as miraj]
            [miraj.html :as h]
            ;; for testing only:
            [miraj.co-dom :as x]
            :reload))

(miraj/defpage
  "Input Test."
  {::h/title "Polymer Dom Binding Test"
   ::h/description "This page demonstrates Polymer binding."}
  (:require [miraj.polymer.iron :as iron :refer [input]]
            [miraj.polymer.paper :as paper :refer [button]]
            [miraj.polymer.dom :as dom :refer [lambda]])
  (:styles [[miraj.polymer.paper.styles color demo-pages typography]])

  (:body :!unresolved
         (h/h1 "Polymer " (h/span "<dom-binding>") " Demo")
         (h/div :#mydiv.vertical-section!vertical-section-container!centered
                (dom/lambda [value :two-way bind-value]
                            (h/p
                             (h/input {:is "iron-input"
                                       :bind-value bind-value
                                       :value "{{value::input}}"})
                             (h/br)
                             "bind to " (h/code "bind-value")   ": " (h/b bind-value)
                             (h/br)
                             "bind to " (h/code "value::input") ": " (h/b value))

                            (h/p {:on-click "setValue"}
                                 "set bind-value to: " (h/input) (h/button {:is "paper-button"
                                                                            :value "bindValue"} "set")
                                 (h/br)
                                 "set value to: " (h/input) (h/button {:value "value"} "set")))
                            )))

(binding [miraj/*debug* true
            miraj/*verbose* true
            miraj/*keep* true
            miraj/*pprint* true
            *compile-path* "target"]
  (miraj/mcc :page 'miraj.polymer.dom.binding-test
             ;; :page 'miraj.polymer.dom.binding-test/foopage
             :polyfill :lite ;; :full, :imports, :components, :shadow
             :imports ["imports.html"]))

