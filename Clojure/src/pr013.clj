
(ns clojure.euler (:use [clojure.contrib.duck-streams :only (read-lines)]))


(defn getBigInt [x]
  (if (instance? BigInteger x) x (BigInteger. x))
  )
(println (time (reduce #(.add (getBigInt %1) (getBigInt %2) ) (read-lines "../pr13.txt"))))