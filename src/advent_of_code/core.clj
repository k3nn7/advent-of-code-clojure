(ns advent-of-code.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [advent-of-code.day1.part1 :as d1p1])
  (:require [advent-of-code.day1.part2 :as d1p2]))


(defn- call-mapping-function
    [mapping day part]
    (if (contains? mapping day)
        (let [day-mapping (mapping day)]
            (if (contains? day-mapping part)
                (let [part-fn (day-mapping part)]
                    (part-fn))
                (str part " for " day " is not implemented")))
        (str day " is not implemented")))

(defn call-day-and-part
    "Calls appropriate function for day and part given as a parameter"
    [mapping & args]
    (if (>= (count args) 2)
        (let [day (nth args 0)
              part (nth args 1)]
              (call-mapping-function mapping day part))
        "Please provide day and part number. E.g. advent-of-code day5 part2"
        ))

(defn load-input
    [resource]
    (slurp (io/file (io/resource resource))))

(def implemented {
    "day1" {
        "part1" (fn [] (d1p1/move-santa (load-input "day1")))
        "part2" (fn [] (d1p2/when-enters-basement (load-input "day1")))
        }})

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (apply
            call-day-and-part
            (concat [implemented] args))))
