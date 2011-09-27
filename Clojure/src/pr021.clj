
(defn properDivisorSum[num]
  (apply + (map #( if (= (mod num %) 0) % 0 ) (range 1 (inc (/ num 2)))))
  )

(defn amicable [num]
  (let [t (properDivisorSum num)]
    (if (= t num) 0 (if (= (properDivisorSum t) num) num 0))
    )
  )

;(println (properDivisorSum 284) (properDivisorSum 220) (amicable 284) (amicable 220) (amicable 221))

(println (time (apply + (map amicable (range 1 10000)))))


