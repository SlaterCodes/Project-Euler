(use 'clojure.contrib.math)

(defn digitSum [num]
  (apply + (map #(Integer/parseInt (str %)) (.toCharArray (str num)))))

(defn fatorial [num]
  (apply * (range 1 num)))

(println (digitSum (fatorial 100)))
