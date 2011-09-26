

;If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;Find the sum of all the multiples of 3 or 5 below 1000.


(defn naturalSum [topNum]
  (loop [total 0 top (- topNum 1)]
      (if (= top 0) total
        (if (or (= (mod top 5) 0) (= (mod top 3) 0))
          (recur (+ total top) (- top 1))
          (recur total (- top 1))
	      )
	    )
    )
  )

  
(println (time(naturalSum 1000)))
