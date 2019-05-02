(ns logic-programming.teaching-old-toys-new-tricks
  (:require [clojure.core.logic :refer :all]))

(def acorn '(a c o r n))

;;1
(first '(grape raisin pear))

;;2
(first acorn)

;;3
(run* [q]
  (firsto acorn))

;;4
(run* [q]
  (firsto acorn 'a))

;;5
(run* [r]
  (fresh [x y]
    ;; r is fused with x
    (firsto (lcons r (cons y ())) x)
    (== 'pear x)))

;;6 defrel (caro p a)

;;7
(cons
  (first '(grape raisin pear))
  (first '((a) (b) (c))))

;;8
(run* [r]
  (fresh [x y]
    (firsto '(grape raisin pear) x)
    (firsto '((a) (b) (c)) y)
    (== (lcons x y) r)))

;;10
(rest '(grape raisin pear))

;;11
(first (rest (rest acorn)))

;;12
(run* [r]
  (fresh [v]
    (resto acorn v)
    (fresh [w]
      (resto v w)
      (firsto w r))))

;;14
(cons
  (rest '(grape raisin pear))
  (first '((a) (b) (c))))

;;15
(run* [r]
  (fresh [x y]
    (resto '(grape raisin pear) x)
    (firsto '((a) (b) (c)) y)
    (== (lcons x y) r)))

;;16
(run* [q]
  (resto acorn (rest acorn)))

;;17
(run* [x]
  (resto (rest acorn)
         (lcons x (rest (rest (rest acorn))))))

;;18
(run* [l]
  (fresh [x]
    (resto l (rest acorn))
    (firsto l x)
    (== 'a x)))

;;19
(run* [l]
  (conso '(a b c) '(d e) l))

;;20
(run* [x]
  (conso x '(a b c) '(d a b c)))

;;21
(run* [r]
  (fresh [x y z]
    (== (cons 'e (cons 'a (cons 'd (cons x ())))) r)
    (conso y (cons 'a (lcons z (cons 'c ()))) r)))

;;22
(run* [x]
  (let [l (cons 'a (lcons x (cons 'c ())))]
    (conso x l (cons 'd l))))

;;23
(run* [l]
  (fresh [x]
    (== (cons 'd (cons 'a (lcons x (cons 'c ())))) l)
    (conso x (cons 'a (lcons x (cons 'c ()))) l)))

;;24
(run* [l]
  (fresh [x]
    (conso x (cons 'a (lcons x (cons 'c ()))) l)
    (== (cons 'd (cons 'a (lcons x (cons 'c ())))) l)))

;; llist?
(run* [l]
  (fresh [x]
    (conso x (llist x 'a 'c ()) l)
    (== (llist 'd 'a x 'c ()) l)))


;;25 defrel conso using caro and cdro

;;26 defrel cosno using ==

;;27
(run* [l]
  (fresh [d t x y w]
    (conso w '(n u s) t)
    (resto l t)
    (firsto l x)
    (== 'b x)
    (resto l d)
    (firsto d y)
    (== 'o y)))

;;28
(nil? '(grape raisin pear))

;;29
(nil? '())
; (empty? '())

;;30
(run* [q]
  (emptyo '(grape raisin pear)))

;;31
(run* [q]
  (emptyo '()))

;;32
(run* [x]
  (emptyo x))

;;33 defrel nullo

;;34 - 40 about pair (lcons 'split 'pea)

;;41
(first '(pear))

;;42
(rest '(pear))

;;44
(lcons '(split) 'pear)

;;45
(run* [r]
  (fresh [x y]
    (== (lcons x (lcons y 'salad)) r)))

;;46 defrel pairo

(defn pair? [x]
  (or (lcons? x) (and (coll? x) (seq x))))

;;47 pairo...?
;;(run* [q]
;;  (pair (lcons q q)))

;;58 clojure.core.logic.LCons に対して singleton? が定義できない
;;(defn singleton? [l]
;;  (or
;;    (and (pair? l) (nil? (rest l)))
;;    false))