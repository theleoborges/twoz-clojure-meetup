(defn divisible? [num]
  #(zero? (rem %1 num)))

(defn divisible-by-any? [denoms]
  (fn [num] (some
             #(true? (%1 num))
             (map #(divisible? %1) denoms))))

(defn problem1 [limit]
  (reduce + 0 (filter
               (divisible-by-any? [3 5])
               (range 0 limit))))

(assert (== 0 (problem1 0)))
(assert (== 0 (problem1 1)))
(assert (== 3 (problem1 4)))
(assert (== 33 (problem1 11)))
(assert (== 233168 (problem1 1000)))