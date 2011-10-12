(defn multiples-of [num]
  (iterate (partial + num) 0))

(defn values-under-1k [somenumbers]
  (take-while (partial > 1000) somenumbers))

(apply + (distinct (into
  (values-under-1k (multiples-of 3))
  (values-under-1k (multiples-of 5))))) 

