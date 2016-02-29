(ns advent-of-code.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [advent-of-code.day1.part1 :as d1p1])
  (:require [advent-of-code.day1.part2 :as d1p2])
  (:require [advent-of-code.day2.part1 :as d2p1])
  (:require [advent-of-code.day2.part2 :as d2p2])
  (:require [advent-of-code.day3.part1 :as d3p1])
  (:require [advent-of-code.day3.part2 :as d3p2])
  (:require [advent-of-code.day4.part1 :as d4p1])
  (:require [advent-of-code.day5.part1 :as d5p1]))


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
    ((comp slurp io/file io/resource) resource))

(def implemented {
    "day1" {
        "part1" #((comp d1p1/move-santa
                        load-input) "day1")
        "part2" #((comp d1p2/when-enters-basement
                        load-input) "day1")
        },
    "day2" {
        "part1" #((comp d2p1/calc-total-amount
                        load-input) "day2")
        "part2" #((comp d2p2/calc-total-amount
                        load-input) "day2")
      }
    "day3" {
        "part1" #((comp d3p1/count-visited-houses
                        d3p1/visit-given-houses
                        load-input) "day3")
        "part2" #((comp d3p2/count-visited-houses
                        d3p2/visit-given-houses
                        load-input) "day3")
      }
    "day4" {
        "part1" #(d4p1/find-hash "iwrupvqb" "00000")
        "part2" #(d4p1/find-hash "iwrupvqb" "000000")
      }
    "day5" {
      "part1" #((comp d5p1/count-nice-strings
                      load-input) "day5")
      ; "part2" #(d4p1/find-hash "iwrupvqb" "000000")
    }
    })

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (apply
            call-day-and-part
            (concat [implemented] args))))
