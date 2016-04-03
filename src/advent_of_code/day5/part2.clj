(ns advent-of-code.day5.part2
    (:require [clojure.string :refer [includes? split]]))

(defn- pair
    [string]
    (apply str (take 2 string)))

(defn get-all-pairs
    [string]
    (let [letters (seq string)]
        (loop [remaining-letters letters pairs []]
            (if (< (count remaining-letters) 2)
                pairs
                (let [pair (pair remaining-letters)]
                      (recur (rest remaining-letters)
                             (into [] (set (conj pairs pair)))))))))

(defn count-substring
    [string sub]
    (->> string
         (re-seq (re-pattern sub))
         count))

(defn- pair-count
    [string pair-count pair]
    (assoc pair-count
           pair
           (count-substring string pair)))

(defn count-pairs
    [string]
    (let [pairs (get-all-pairs string)]
        (reduce (partial pair-count string) {} pairs)))

(defn has-double-double?
    [string]
    (let [pairs (count-pairs string)]
        (let [sorted-counts (sort > (vals pairs))]
            (>= (first sorted-counts) 2))))

(defn- starts-with-triple?
    [letters]
    (= (nth letters 0) (nth letters 2)))

(defn has-triple?
    [string]
    (let [letters (seq string)]
        (loop [letters letters]
            (if (> 3 (count letters))
                false
                (if (starts-with-triple? letters)
                    true
                    (recur (rest letters)))))))

(defn nice?
    [string]
    (and (has-double-double? string)
         (has-triple? string)))

(defn- parse-input
    [input]
    (split input #"\n"))

(defn count-nice-strings
    [input]
    (let [strings (parse-input input)]
        (count (filter #(= true %)
            (map nice? strings)))))
