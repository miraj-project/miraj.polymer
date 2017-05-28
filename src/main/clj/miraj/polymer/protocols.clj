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

