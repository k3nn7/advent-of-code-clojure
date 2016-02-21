(ns advent-of-code.day3.part1
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
    [[position visited] command]
    (let [new-position (move position command)]
        [new-position (visit-house visited new-position)]))

(defn visit-given-houses
    [commands]
    (reduce handle-command
            [[0 0] [{:x 0 :y 0 :visits 1}]]
            (seq commands)))

(defn count-visited-houses
    [[position visited]]
    (count visited))

