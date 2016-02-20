(ns advent-of-code.day2.part1
    (:gen-class))

(defn calc-paper-amount
    [l w h]
    (let [a (* l w)
          b (* w h)
          c (* h l)]
              (+ (* 2 a)
                 (* 2 b)
                 (* 2 c)
                 (min a b c))))

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
                (+ total (apply calc-paper-amount dimension)))
            0
            dimensions)))
