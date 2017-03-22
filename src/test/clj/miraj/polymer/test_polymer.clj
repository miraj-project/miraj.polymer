(ns miraj.html.test-polymer
  (:require [miraj.co-dom :as codom]
            ;; [miraj.html :as h]
            [miraj.polymer :as p]
            :reload))

;; (println "loading work.pages.minimal")

;; polymer helpers - just another lib in a ns, like miraj.html, no special semantics
;; but do we want to test them here in the html lib?

;; currently miraj.polymer is in core, move it to miraj/html? separate lib seems overkill

;; but co-dom already understands part of pmer, put miraj.polymer there?

;; what about protocols, extensions, etc.?  make a new project for miraj.polymer

;; but make one miraj lib containing all except the polymer
;; component libs: co-dom, html, polymer, miraj.core

(codom/serialize (p/bind))
(codom/serialize (p/if))
(codom/serialize (p/module))
(codom/serialize (p/repeat))
(codom/serialize (p/selected-items))
(codom/serialize (p/style))

