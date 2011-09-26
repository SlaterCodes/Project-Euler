(use 'clojure.contrib.math)

;2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn islcm [thenum nums]
	(if (empty? nums)
		true
		(if (= (mod thenum (first nums)) 0)
			(recur thenum (rest nums))
			false
			)
		)
	)

(defn thelcm [nrange]
	; we may as well start at the lcm of the highest 2 numbers in the range
	(loop [n (lcm (first nrange) (second nrange))]
		(if (islcm n nrange)
			n
			(recur (+ n 1))
			)
		)
	)
 ; reversing the range speeds up the algorithm considerably because islcm will check the largest to smallest factors which will result in quicker fails
 (println (time (thelcm (reverse (range 1 20)))))
;"Elapsed time: 59987.201506 msecs"
;232792560