(ns miraj.Polymer)

#_(alter-meta! *ns*
             (fn [m] (assoc m
                            :co-ns true
                            :resource-type :polymer
                            :resource-pfx "bower_components")))

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
  Http
  (request [rqst])
  (response [rsp])
  (error [e]))

