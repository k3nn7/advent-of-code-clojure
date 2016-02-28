(ns advent-of-code.day3.part2
    (:gen-class))

(defn- has-coordinates?
    [house x y]
    (let [{house-x :x house-y :y} house]
        (and (= house-x x) (= house-y y))))

(defn visited?
    [houses x y]
    []
    (loop [remaining-houses houses]
        (let [[house & remaining] remaining-houses]
            (if (has-coordinates? house x y)
                true
                (if (empty? remaining)
                    false
                    (recur remaining))))))

(defn inc-visits
    [x y]
    (fn [house]
        (if (has-coordinates? house x y)
            {:x x :y y :visits (inc (house :visits))}
            house)))

(defn visit-house
    [visited [x y]]
    (if (visited? visited x y)
        (map (inc-visits x y) visited)
        (conj visited {:x x :y y :visits 1})))

(defn move
    [[x y] command]
    (case command
        \> [(inc x) y]
        \< [(dec x) y]
        \^ [x (inc y)]
        \v [x (dec y)]
        [x y]))

(defn- handle-command
    [[santa santa-pos robo-pos visited] command]
    (condp = santa
        true (let [new-santa-pos (move santa-pos command)]
              [(not santa) new-santa-pos robo-pos (visit-house visited new-santa-pos)])
        false (let [new-robo-pos (move robo-pos command)]
              [(not santa) santa-pos new-robo-pos (visit-house visited new-robo-pos)])
    ))


(defn visit-given-houses
    [commands]
    (reduce handle-command
            [true [0 0] [0 0] [{:x 0 :y 0 :visits 2}]]
            (seq commands)))

(defn count-visited-houses
    [[santa santa-pos robo-pos visited]]
    (count visited))

