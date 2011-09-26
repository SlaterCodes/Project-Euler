
;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;Find the sum of all the primes below two million.

(use 'clojure.set)
(use 'clojure.contrib.lazy-seqs)

(defn candiv [num primes]
	(= (some #{0} (map #(mod num %) primes)) 0)
	)

(defn get-primes-to-n [num]
	(loop [currentVal 3 plist #{2}]
		(if (>= currentVal num) plist
			(if (candiv currentVal plist)
				(recur (+ currentVal 2) plist)
				(recur (+ currentVal 2) (union plist #{currentVal}))
				))
		)
	)

(comment
	(let [mp (time(get-primes-to-n 2000000))]
	(println (apply + mp))
	)
	)

(println (apply + (take-while #(< % 2000000) primes)))