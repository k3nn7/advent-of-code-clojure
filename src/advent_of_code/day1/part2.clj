(ns advent-of-code.day1.part2
    (:gen-class))

(defn- parse-santa-command
    [command]
    (case command
        \( 1
        \) -1))

(defn when-enters-basement
    [moves]
    (let [moves-seq (seq moves)]
        (loop [floor 0
               iteration 0
               remaining-moves moves-seq]
            (if (= floor -1)
                iteration
                (let [[cmd & remaining] remaining-moves]
                    (recur (+ floor (parse-santa-command cmd))
                           (inc iteration)
                           remaining))
                )
        )))
