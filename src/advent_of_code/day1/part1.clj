(ns advent-of-code.day1.part1
    (:gen-class))

(defn- parse-santa-command
    [command]
    (case command
        \( 1
        \) -1))

(defn move-santa
    [moves]
    (reduce
        (fn [floor cmd ](+ floor (parse-santa-command cmd)))
        0
        (seq moves)))
