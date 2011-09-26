;The prime factors of 13195 are 5, 7, 13 and 29.
;What is the largest prime factor of the number 600851475143 ?
(use 'clojure.contrib.math)
(use 'clojure.set)


(defn isPrime [num]
	(loop [t (first (exact-integer-sqrt num))]
		(if (= t 1) true
			(if (= (mod num t) 0) false (recur (- t 1))
				))
		)
	)

(defn primeFactors [num]
	(loop [st 2 track num factors ()]
		(if (and (<= st (/ num 2)) (> track 1) )
			(if (isPrime st)
				(if (= (mod track st) 0)
					(recur st (/ track st) (conj factors st))
					(recur (+ st 1) track factors)
					)
				(recur (+ st 1) track factors)
				)
			factors
			)
		)
	)

(time (def factors (primeFactors 600851475143)))
(println "Factors: " factors)
(println "Max: " (apply max-key max factors))           ; 6857
