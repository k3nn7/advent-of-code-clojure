(ns advent-of-code.day2.part2
    (:gen-class))

(defn calc-ribbon-amount
    [l w h]
    (let [sorted (sort [l w h])]
        (let [min1 (nth sorted 0)
              min2 (nth sorted 1)]
            (+ (* 2 min1) (* 2 min2) (* l w h)))))

(defn parse-dimensions
    [dimensions]
    (map (fn [x] (Integer. x)) (clojure.string/split dimensions #"x")))

(defn parse-input
    [input]
    (map
        (fn [dimension] (parse-dimensions dimension))
        (clojure.string/split input #"\n")))

(defn calc-total-amount
    [input]
    (let [dimensions (parse-input input)]
        (reduce
            (fn [total dimension]
                (+ total (apply calc-ribbon-amount dimension)))
            0
            dimensions)))
