(ns advent-of-code.day4.part1
    (:require [digest]
              [clojure.string]))

(defn find-hash
    [input prefix]
    (loop [i 0]
        (let [string (str input i)]
            (let [hash (digest/md5 string)]
                (if (clojure.string/starts-with? hash prefix)
                    i
                    (recur (inc i)))))))
