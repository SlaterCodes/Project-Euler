;By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;What is the 10 001st prime number?

(use 'clojure.set)

(defn candiv [num primes]
	(= (some #{0} (map #(mod num %) primes)) 0)
	)

(defn get-prime-n [num]
	(loop [currentVal 3 primes #{2}]
		(if (= (count primes) num) (- currentVal 2)
			(if (candiv currentVal primes)
				(recur (+ currentVal 2) primes)
				(recur (+ currentVal 2) (union primes #{currentVal}))
				))
		)
	)
(println (time (get-prime-n 10001)))
;"Elapsed time: 74359.857921 msecs"
;104743
