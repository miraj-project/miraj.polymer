(ns miraj.polymer
  "Polymer Data-binding Helpers

  https://www.polymer-project.org/2.0/docs/devguide/templates"
  (:refer-clojure :exclude [for])
  (:require [miraj.co-dom :as codom :refer [element]]))

;;(println "loading miraj.polymer")

(alter-meta! *ns* (fn [m] (assoc m :miraj/miraj {:miraj/elements true
                                                 :miraj/nss '[]
                                                 :miraj/codom ""
                                                 :miraj/polymer-version "2.0.0-rc.3"
                                                 :miraj/assets
                                                 {:miraj/bower
                                                  [
                                                   ]
                                                   :miraj/base "/bower_components/"}})))


;;;;;;;; COMPONENT: miraj.polymer/selected-items ;;;;;;;;;;;;;;;;
(defn selected-items
  "<array-selector> links data binding for arrays..

  https://www.polymer-project.org/2.0/docs/devguide/templates#array-selector"
  [& args]
  (apply codom/element :array-selector args))
(alter-meta! (find-var (symbol (str *ns*) "selected-items"))
             (fn [old new] (merge old new))
             {:miraj/miraj {:miraj/co-fn true
                            :miraj/element true
                            :miraj/html-tag :array-selector
                            :miraj/lib :miraj.polymer
                            :miraj/assets {:miraj/href "/bower_components/polymer/lib/elements/array-selector.html"
                                           :miraj/version "2.0.0-rc.3"
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
                            :miraj/assets {:miraj/href "/bower_components/polymer/lib/elements/dom-bind.html"
                                           :miraj/version "2.0.0-rc.3"
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
                            :miraj/assets {:miraj/href "/bower_components/polymer/lib/elements/dom-if.html"
                                           :miraj/version "2.0.0-rc.3"
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
                            :miraj/assets {:miraj/href "/bower_components/polymer/lib/elements/dom-module.html"
                                           :miraj/version "2.0.0-rc.3"
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
                            :miraj/assets {:miraj/href "/bower_components/polymer/lib/elements/dom-repeat.html"
                                           :miraj/version "2.0.0-rc.3"
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
                            :miraj/assets {:miraj/href "/bower_components/polymer/lib/elements/custom-style.html"
                                           :miraj/version "2.0.0-rc.3"
                                           :miraj/bower "Polymer/polymer"}
                            :miraj/help "https://www.polymer-project.org/2.0/docs/devguide/templates#custom-style"}})
