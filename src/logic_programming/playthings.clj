(ns logic-programming.playthings
  (:require [clojure.core.logic :as l]))

(l/run* [q]
        l/u#)

(l/run* [q]
        (l/== 'pea 'pod))

(l/run* [q]
        (l/== 'pea q))




