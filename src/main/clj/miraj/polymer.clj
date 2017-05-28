;; these namespaces are for qualifying keywords (do we need this?)
(ns miraj.polymer.binding.one)
(ns miraj.polymer.binding.two)

;; this is the ns of this file
(ns miraj.polymer
  "Polymer functions and helpers"
  (:refer-clojure :exclude [for repeat])
  (:require [miraj.co-dom :as codom :refer [element]]
            [clojure.tools.logging :as log :only [trace debug error warn info]]))

;;(println "loading miraj.polymer")

(alter-meta! *ns* (fn [m] (assoc m :miraj/miraj {:miraj/elements true
                                                 :miraj/nss '[]
                                                 :miraj/codom ""
                                                 :miraj/polymer-version "1.8.1"
                                                 :miraj/assets
                                                 {:miraj/bower
                                                  [
                                                   ]
                                                   :miraj/base "/miraj/polymer/assets/"}})))

(defn bind!
  "one-way property binding"
  [sym]
  (str "[[" (name sym) "]]"))
  ;;(keyword "miraj.polymer.binding.one" (name sym)))

(defn bind!!
  "two-way property binding"
  [sym]
  (str "{{" (name sym) "}}"))

(defn bind-attr!
  "one-way attribute binding"
  [sym]
  (keyword "miraj.polymer.binding.attr.one" (name sym)))

(defn bind-attr!!
  "two-way attribute binding"
  [sym]
  (keyword "miraj.polymer.binding.attr.two" (name sym)))


;;;;;;;; COMPONENT: miraj.polymer/slot ;;;;;;;;;;;;;;;;
(defn slot
  "<slot> - component composition"
  [& args]
  (apply codom/element :slot args))
#_(alter-meta! (find-var (symbol (str *ns*) "selection"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :array-selector
                            :miraj/lib :miraj.polymer
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/api/"}})


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;  Polymer Helper Elements
;;  https://www.polymer-project.org/2.0/docs/devguide/templates"


(defmacro lambda
   "Wrapper on <dom-bind>. args is a vector of symbols, with optional keyword :two-way, and will be used to construct a let-expression. Symbols preceding :two-way will be bound to one-way binding annotation, e.g. [foo] => [foo \"[[foo]]\"]. Symbols following :two-way will be bound to two-way binding annotation, e.g. [:two-way foo] => [foo \"{{foo}}\"]. body will be evaluated with reconstructed let bindings and wrapped in <template is=\"dom-bind\">.

  https://www.polymer-project.org/2.0/docs/devguide/templates#array-selector"
  [args & body]
  (let [argvec args
        _ (if (not (vector? argvec)) (throw (Exception. "First arg to miraj.polymer.dom/lambda must be a vector")))
        [oneway x twoway] (if (= :two-way (first argvec))
                            [nil nil (rest argvec)]
                            (partition-by #(= :two-way %) argvec))
        oneway (into [] (mapcat identity (clojure.core/for [arg oneway] [arg (str "[[" arg "]]")])))
        twoway (into [] (mapcat identity (clojure.core/for [arg twoway] [arg (str "{{" arg "}}")])))
        newvec (concat oneway twoway)
        ;; body (rest args)
        ]
    `(binding [*ns* ~*ns*]
       (let [~@newvec]
         (codom/element :template {:is "dom-bind"} ~@body)))))

(alter-meta! (find-var (symbol (str *ns*) "lambda"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/help "https://www.polymer-project.org/2.0/docs/devguide/templates"
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}}})

;;;;;;;; COMPONENT: miraj.polymer/selected-items ;;;;;;;;;;;;;;;;
(defn selection
  "<array-selector> links data binding for arrays..

  https://www.polymer-project.org/2.0/docs/devguide/templates#array-selector"
  [& args]
  (apply codom/element :array-selector args))
(alter-meta! (find-var (symbol (str *ns*) "selection"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :array-selector
                            :miraj/lib :miraj.polymer
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/api/"}})

;;;;;;;; COMPONENT: miraj.polymer/bind ;;;;;;;;;;;;;;;;
(defn bind
  "Auto-binding template <dom-bind>.

  https://www.polymer-project.org/2.0/docs/devguide/templates#dom-bind"
  [& args]
  (apply codom/element :dom-bind args))
(alter-meta! (find-var (symbol (str *ns*) "bind"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :dom-bind
                            :miraj/lib :polymer
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/devguide/templates#dom-bind"}})

;;;;;;;; COMPONENT: miraj.polymer/if ;;;;;;;;;;;;;;;;
(defn if
  "The <dom-if> template stamps its contents into the DOM only when its if property becomes truthy.

  https://www.polymer-project.org/2.0/docs/devguide/templates#dom-if"
  [& args]
  (apply codom/element :dom-if args))
(alter-meta! (find-var (symbol (str *ns*) "if"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :dom-if
                            :miraj/lib :polymer
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/devguide/templates#dom-if"}})

;;;;;;;; COMPONENT: miraj.polymer/module ;;;;;;;;;;;;;;;;
(defn module
  "<dom-module>

  https://www.polymer-project.org/2.0/docs/devguide/templates#dom-module"
  [& args]
  (apply codom/element :dom-module args))
(alter-meta! (find-var (symbol (str *ns*) "module"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :dom-module
                            :miraj/lib :miraj.polymer
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/devguide/templates#dom-module"}})

;;;;;;;; COMPONENT: miraj.polymer/repeat ;;;;;;;;;;;;;;;;
(defn repeat
  "Template repeater <dom-repeat>. The template repeater is a specialized template that binds to an array. It creates one instance of the template's contents for each item in the array. For each instance, it creates a new data binding scope.

  https://www.polymer-project.org/2.0/docs/devguide/templates#dom-repeat"
  [& args]
  (apply codom/element :dom-repeat args))
(alter-meta! (find-var (symbol (str *ns*) "repeat"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :dom-repeat
                            :miraj/lib :polymer
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/devguide/templates#dom-repeat"}})

;;;;;;;; COMPONENT: miraj.polymer/style ;;;;;;;;;;;;;;;;
(defn style
  "<custom-style> - document-level styling for legacy browsers.

  https://www.polymer-project.org/2.0/docs/devguide/templates#"
  [& args]
  (apply codom/element :custom-style args))
(alter-meta! (find-var (symbol (str *ns*) "style"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :custom-style
                            :miraj/lib :polymer
                            :miraj/assets {:miraj/href "/miraj/polymer/assets/polymer/polymer.html"
                                           :miraj/version "1.8.1"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/devguide/templates#custom-style"}})

;;(println "loaded miraj.polymer")
