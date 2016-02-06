(ns advent-of-code.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code.core :refer :all]
            [clojure.string :as string]))

(def mapping {
    "day1" {
        "part1" (fn [] "day1 part1 called")
    }})

(deftest call-day-and-part-test
    (testing "Call day and part from arguments"
        (testing "with no arguments provided"
            (is (string/includes?
                    (call-day-and-part mapping)
                    "Please provide day and part number")))
        (testing "with only day provided"
            (is (string/includes?
                    (call-day-and-part mapping "day1")
                    "Please provide day and part number")))
        (testing "with valid day and part provided"
            (is (string/includes?
                    (call-day-and-part mapping "day1" "part1")
                    "day1 part1 called")))
        (testing "with invalid day provided"
            (is (string/includes?
                    (call-day-and-part mapping "day5" "part1")
                    "day5 is not implemented")))
        (testing "with valid day but invalid part"
            (is (string/includes?
                    (call-day-and-part mapping "day1" "part2")
                    "part2 for day1 is not implemented")))))

(deftest load-input-test
    (testing "Load input file"
        (testing "that exists"
            (is (= "input data\n" (load-input "example"))))))
