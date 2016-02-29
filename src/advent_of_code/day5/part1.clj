(ns advent-of-code.day5.part1
    (:require [clojure.string :refer [includes? split]]))

(defn- has-vowels?
    [string]
    (not (nil? (re-find #"(.*?[aeiou].*?){3}" string))))

(defn- has-double-letter?
    [string]
    (let [letters (seq string)]
        (loop [remaining-letters letters previous nil]
            (if (empty? remaining-letters)
                false
                (let [[letter & remaining] remaining-letters]
                    (if (= previous letter)
                        true
                        (recur remaining letter)))))))

(defn- has-naughty-substrings?
    [s]
    (or (includes? s "ab")
        (includes? s "cd")
        (includes? s "pq")
        (includes? s "xy")))

(defn- parse-input
    [input]
    (split input #"\n"))

(defn nice?
    [string]
    (and (has-vowels? string)
         (has-double-letter? string)
         (not (has-naughty-substrings? string))))

(defn count-nice-strings
    [input]
    (let [strings (parse-input input)]
        (count (filter #(= true %)
            (map nice? strings)))))
