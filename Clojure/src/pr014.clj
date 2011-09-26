

(defn specseq [num]
  (loop [curNum num numsCount 0]
    (if (= curNum 1) (inc numsCount)
      (if (even? curNum)
        (recur (/ curNum 2) (inc numsCount))
        (recur (inc (* curNum 3)) (inc numsCount))
        )
      )
    )
  )

(def natural-nums (iterate inc 1))

(time (let [crazyMap (zipmap (map specseq (take 1000000 natural-nums)) (take 1000000 natural-nums))]
  (println (get crazyMap (apply max (keys crazyMap))))
  ))
