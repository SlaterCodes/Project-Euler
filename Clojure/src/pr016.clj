(use 'clojure.contrib.math)

(defn digitSum [num]
  (apply + (map #(Integer/parseInt (str %)) (.toCharArray (str num)))))

(println (time(digitSum (expt 2 1000))))
