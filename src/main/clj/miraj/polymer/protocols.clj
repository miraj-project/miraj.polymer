(ns miraj.polymer.protocols)

(alter-meta! *ns* (fn [m] (assoc m
                                 :miraj/miraj {:miraj/co-ns true
                                               :miraj/resource-type :protocols})))

(defprotocol ^{:co-protocol? true}
  This)

(defprotocol ^{:co-protocol? true}
  Lifecycle
  (created [this])
  (attached [this])
  (detached [this])
  (attributeChanged [this])
  (ready [this]))

(defprotocol ^{:co-protocol? true}
    Gesture
  "Polymer Gesture Events https://www.polymer-project.org/1.0/docs/devguide/gesture-events"
  (down [evt])
  (up [evt])
  (tap [evt])
  (track [evt]))
