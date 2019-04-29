(ns logic-programming.core
  (:require [clojure.core.logic :refer :all]))

;; https://github.com/clojure/core.logic/wiki/A-Core.logic-Primer

(run* [q]
      (membero q [1 2 3])
      (membero q [2 3 4]))

;; Mental shortcut is to view unify as constraining q to be equal to 1.
(run* [q]
      (== q 1))

(run* [q]
      (== q {:a 1 :b 2}))

(run* [q]
      (== {:a q :b 2} {:a 1 :b 2}))

;; order is irrelevant
(run* [q]
      (== 1 q))

(run* [q]
      (== q '(1 2 3)))
;; => ((1 2 3))

(run* [q]
      (== q 1)
      (== q 2))

(run* [q]
      (membero q [1 2 3]))

(run* [q]
      (membero q [1 2 3])
      (membero q [3 4 5]))

(run* [q]
      (fresh [a]
             (membero a [1 2 3])
             (membero q [3 4 5])
             (== a q)))

(comment
  (run* [q]
        (conde
          [goal1 goal2 ...]
          ...))

  " a bit like this:"

  (run* [q]
        (OR
          [goal1 AND goal2 AND ...]
          ...)))

(run* [q]
      (conde
        [(== q 2) (== q 1)]))

(run* [q]
      (conde
        [(== q 1)]
        [(== q 2)]))

(run* [q]
      (conso 1 [2 3] q))
;; => ((1 2 3))

(run* [q]
      (conso 1 q [1 2 3]))
;; => ((2 3))

(run* [q]
      (conso q [2 3] [1 2 3]))
;; => (1)

(run* [q]
      (conso 1 [2 q] [1 2 3]))
;; => (3)

(run* [q]
      (resto [1 2 3 4] q))
;; => ((2 3 4))

(run* [q]
      (membero 7 [1 3 8 q]))
;; => (7)