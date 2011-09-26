;A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.

;Find the largest palindrome made from the product of two 3-digit numbers.

(require '[clojure.string])
(use 'clojure.contrib.math)

(defn palcheck [num]
	(= (compare (clojure.string/reverse (str num)) (str num)) 0)
	)

(defn loop2 [mulnum digits]
	(loop [num1 (- (expt 10 digits) 1)]
		(if (>= num1 (expt 10 (- digits 1)))
			(let [res (* num1 mulnum)]
				(if (palcheck res)
					res
					(recur (- num1 1))
					)
				)
			0
			)
		)
	)

(defn loop1 [digits]
	(loop [num1 (- (expt 10 digits) 1) pal digits]
		(if (>= num1 (expt 10 (- digits 1)))
			(let [res (loop2 num1 digits)]
				(if (> res pal) (recur (- num1 1) res) (recur (- num1 1) pal))
				)
			pal
			)
		)
	)

(println (time (loop1 3)))