(ns logic-programming.playthings
  (:use [clojure.core.logic]))

;; The Reasoned Schemer 2nd Edition

(run* [q]
      u#)

(run* [q]
      (== 'pea 'pod))

(run* [q]
      (== 'pea q))

;; Tow different fresh variables can be made the same by fusing them.
;; We fuse two different fresh variables using ==.

(run* [q]
      (fresh [x]
             (== x q)))

(run* [q]
      (== 'pea 'pea))

(run* [q]
      (fresh [x]
             (== '(x x) q)))

(run* [q]
      (fresh [x]
             (fresh [y]
                    (== '(q y) '((x y) x)))))

;; 50
(run* [q]
      (conde [s# s#]))

;; q は corn に associated with
(run* [q]
      (conda
        [s# (== 'corn q)]))

(run* [q]
      (conde
        [u# (== 'corn q)]))

(run* [q]
      (conde
        [(== 'corn q) (== 'meal q)]))

(run* [q]
      (conda
        [(== 'corn q) (== 'corn q)]))

(run* [q]
      (conde
        [u# u#]))

(run* [q]
      (conde [(== 'olive q)]
             [u#]))