(ns clojure.euler
  (:use [clojure.contrib.duck-streams :only (read-lines)]))

(defn nameScore [theName]
  (apply + (map #(- (Character/getNumericValue %) 9) (.toCharArray theName)))
  )

(defn totalNameScores [fileName]
  (let [names (sort (map #(.replaceAll % "\"" "") (.split (first (read-lines fileName)) ",")))]
    (loop [idx 0 total 0]
      (if (< idx (count names))
        (recur (inc idx) (+ (* (inc idx) (nameScore (nth names idx))) total))
        total
        )
      )
    )
  )

(println (time (totalNameScores "../../names.txt")))