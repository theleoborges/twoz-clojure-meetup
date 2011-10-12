;;Fabio Lessa
;;Nick Drew

(defn divisible_by_3_or_5 [num]
  (not-every? pos?
     ((juxt #(mod %1 3) #(mod %1 5)) num)))

(defn sum_filter [f sequence]
  (reduce + 0
     (filter f sequence)))

(defn problem1_n [limit]
  (sum_filter
    divisible_by_3_or_5
    (range 1 limit)))
(defn problem1 [] (problem1_n 1000))
;
(tabular "Divisible by 3/5"
  (fact (divisible_by_3_or_5 ?num) => ?expected)
  ?num  ?expected
  3     true
  5     true
  15    true
  2     false
  10    true
  12    true
  4     false
  )

(fact (problem1) => 233168)
(tabular "problem 1"
  (fact (problem1_n ?num) => ?expected)
  ?num  ?expected
  1     0
  3     0
  4     3
  5     3
  6     8
  1000  233168
  )