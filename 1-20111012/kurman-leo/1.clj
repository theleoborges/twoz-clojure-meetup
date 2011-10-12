;;Kurman Karabukaev
;;Leonardo Borges

;;v1
(reduce #(if (or (= (rem %2 3) 0) (= (rem %2 5) 0)) (+ %1 %2)
           %1)
      0
      (take 1000 (iterate inc 0)))

;;v2
(defn divisible [n divisors]
  (some #(= (rem n %1) 0) divisors))

(defn sum [n divisors]
  (reduce #(if (divisible %2 divisors)
             (+ %1 %2)
             %1)
      0
      (take n (iterate inc 0))))

(sum 1000 [3 5])

;;v3
(def sum1
  (comp (partial reduce + 0)
    (partial filter #(or (= (rem %1 3) 0) (= (rem %1 5) 0)))))

(sum1 (take 1000 (iterate inc 0)))