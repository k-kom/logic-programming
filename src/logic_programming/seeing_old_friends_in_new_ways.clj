(ns logic-programming.seeing-old-friends-in-new-ways
  (:require [clojure.core.logic :refer :all]))

;;48
(run* [q]
  (membero 'olive '(virgin olive oil)))

;;49
(run 1 [y]
  (membero y '(hummus with pita)))

;;50
(run 1 [y]
  (membero y '(with pita)))

;;51
(run 1 [y]
  (membero y '(pita)))

;;52
(run 1 [y]
  (membero y '()))

;;53
(run* [y]
  (membero y '(hummus with pita)))

;;55
(run* [y]
  (membero y (lcons 'pear (lcons 'grape 'peaches))))

;;56
(run* [x]
  (membero 'e (cons 'pasta (lcons x (cons 'fagioli ())))))

;;59
;; not run*
(run 1 [x]
  (membero 'e (cons 'pasta (cons 'e (lcons x (cons 'fagioli ()))))))

;;60
;; not run*
(run 1 [x]
  (membero 'e (cons 'pasta (lcons x (cons 'e (cons 'fagioli ()))))))

;;61
(run* [x y]
  (membero 'e (cons 'pasta (lcons x (cons 'fagioli (lcons y ()))))))
; => ([e _0] [_0 e])

;;62
;; We have two values in the list, so one of these value (x or y) should be 'e

;;63
(run* [q]
  (fresh [x y]
    (== (cons 'pasta (lcons x (cons 'fagioli (lcons y ())))) q)
    (membero 'e q)))

;;64
(run 1 [l]
  (membero 'tofu l))
; => ((tofu . _0))
;; よくわからないのだけど、 (tofu . a) は membero が成功する
;; membero は list でなくてもよいらしい? ((tofu . a) は pair のはず)

;;memo
(comment
  (rest (lcons 'a 'b))
  ; IllegalArgumentException Don't know how to create ISeq from: clojure.core.logic.LCons clojure.lang.RT.seqFrom (RT.java:550)
  (rest (lcons 'a ()))
  ; => ()
  (rest (lcons 'b (lcons 'a ())))
  ; => (a)
  )

(run 10 [x]
  (membero 'tofu (lcons 'tofu 'tofu)))

;;65
; (tofu . _0) represents every list whose car is 'tofu

;;66
;; below run* never ends (any list which includes 'tofu)
;;(run* [l]
;;  (membero 'tofu l))

(run 10 [l]
  (membero 'tofu l))

;;73 defrel proper-membero