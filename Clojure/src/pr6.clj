

;The sum of the squares of the first ten natural numbers is,
;12 + 22 + ... + 102 = 385
;The square of the sum of the first ten natural numbers is,
;(1 + 2 + ... + 10)2 = 552 = 3025
;Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025  385 = 2640.
;Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
(use 'clojure.contrib.math)

(defn squareSum [nrange]
	(expt (apply + nrange) 2)
	)

(defn sumSquares [nrange]
	(reduce + (map #(expt % 2) nrange)))

(defn diffOfThem [nums]
	(- (squareSum nums) (sumSquares nums))
	)
;(println (range 1 11))
;(println (sumSquares (range 1 11)))
;(println (squareSum (range 1 11)))

(println (time (diffOfThem (range 1 101))))