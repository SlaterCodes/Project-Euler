;A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

;a2 + b2 = c2
;For example, 32 + 42 = 9 + 16 = 25 = 52.

;There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;Find the product abc.
(use 'clojure.contrib.math)

(defn path [a b]
	(sqrt (+ (expt a 2) (expt b 2)))
	)
(defn ptrip [ans]
	(loop [a 1 b 1]
		(let [c (path a b)]
			(if (> a ans) "Err.")
			(if (= (+ a b c) ans) [a b c]

				(if (< b ans) (recur a (+ b 1)) (recur (+ a 1) 1) )

				)
			)
		)
	)

(let [ans (time(ptrip 1000))]
	(println ans)
	(println (apply * ans))
	)
