(ns logic-programming.playthings
  (:use [clojure.core.logic]))

;;;The Reasoned Schemer 2nd Edition

(comment
  (run* [q]
    (AND () () () ... ))
  (conde
    (OR [AND ...] [AND ...])))

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
    (== '((q) x) '((x) pod))))

(run* [q]
  (fresh [x]
    (== '(x x) q)))

(run* [q]
  (fresh [x]
    (fresh [y]
      (== (lcons q (cons y ())) (lcons (cons x (cons y ())) (cons x ()))))))


;;llist..?
(run* [q]
  (fresh [x]
    (fresh [y]
      (== (llist q '(y))
          (llist '(x y) '(x))))))

;;50
(run* [q]
  (conde [s# s#]))

;;q は corn に associated with
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
  (conde
    [(== 'corn q) (== 'corn q)]))

(run* [q]
  (conde
    [u#]
    [u#]))

(run* [q]
  (conde [(== 'olive q)]
         [u#]))

(run* [q]
  (conde
    [u#]
    [(== 'oil q)]))

(run* [q]
  (conde
    [(== 'olive q)]
    [(== 'oil q)]))

(run* [q]
  (fresh [x]
    (fresh [y]
      (conde
        [(== '(x y) q)]
        [(== '(y x) q)]))))

(run* [x]
  (conde
    [(== 'olive x) u#]
    [(== 'oil x)]))

(run* [x]
  (conde
    [(== 'olive x) s#]
    [(== 'oil x)]))

(run* [x]
  (conde
    [(== 'oil x)]
    [(== 'olive x) s#]))

(run* [x]
  (conde
    [(== 'virgin x) u#]
    [(== 'olive x)]
    [s#]
    [(== 'oil x)]))
;;same as
(comment (run* [x]
           (conde
             ; first constraint always fails
             [(== 'olive x)]
             [s#]
             [(== 'oil x)])))

(run* [r]
  (fresh [x]
    (fresh [y]
      (conde
        [(== 'split x)
         (== 'pea y)
         (== '(x y) r)]))))

(run* [r]
  (fresh [x]
    (fresh [y]
      (conde
        [(== 'split x)
         (== 'pea y)
         (== '(x y) r)]))))

;;70
(run* [r]
  (fresh [x y]
    (conde
      [(== 'split x)
       (== 'pea y)
       (== (lcons x (cons y ())) r)])))

;;72
(run* [r x y]
  (conde
    [(== 'split x)
     (== 'pea y)
     (== (lcons x (cons y ())) r)]))

;;75
(run* [x y]
  (conde
    [(== 'split x)
     (== 'pea y)]))

;;76
(run* [x y]
  (conde
    [(== 'split x) (== 'pea y)]
    [(== 'red x) (== 'bean y)]))

;;77
(run* [r]
  (fresh [x y]
    (conde
      [(conde
         [(== 'split x) (== 'pea y)]
         [(== 'red x) (== 'bean y)])
       (conso x [y 'soup] r)])))

;;80
(run* [x y z]
  (conde
    [(== 'split x) (== 'pea y)]
    [(== 'red x) (== 'bean y)])
  (== 'soup z))

;;81
(run* [x y]
  (== 'split x)
  (== 'pea y))

(defn teacupo [x]
  (conde
    [(== 'tea x)]
    [(== 'cup x)]))

;;83
(run* [x]
  (teacupo x))

;;84
(run* [x y]
  (conde
    [(teacupo x) (== true y)]
    [(== false x) (== true y)]))
;; like for comprehension?
;; I don't know why resulting list's all elements have two elements
; => ([false true] [tea true] [cup true])

;;85
(run* [x y]
  (teacupo x)
  (teacupo y))

;;86
(run* [x y]
  (teacupo x)
  (teacupo x))

;;87
(run* [x y]
  (conde
    ;; x についての constraint のみ
    [(teacupo x) (teacupo x)]
    ;; x と y の constraint
    [(== false x) (teacupo y)]))

;;88
;;introduces conde (con-dee)

;;90
(run* [x y]
  (conde
    [(fresh [z] (== 'lentil z))]
    [(== x y)]))

;;91
(run* [x y]
  (conde
    [(== 'split x) (== 'pea y)]
    [(== 'red x) (== 'bean y)]
    [(== 'green x) (== 'lentil y)]))

;;The Low of conde
;; Every successful conde line contributes one or more values.

