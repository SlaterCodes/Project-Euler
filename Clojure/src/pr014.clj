(defn specseq [num]
  (loop [curNum num numsCount 0]
    (if (= curNum 1) (inc numsCount)
      (if (even? curNum)
        (recur (/ curNum 2) (inc numsCount))
        (recur (inc (* curNum 3)) (inc numsCount))))))

(println (time
  (let [natural-nums (range 1 1000000)]
    (let [crazyMap (zipmap (map specseq natural-nums) natural-nums)]
      (get crazyMap (apply max (keys crazyMap)))))))