(ns advent-of-code.day1.part1-test
    (:require [clojure.test :refer :all]
              [advent-of-code.day1.part1 :refer :all]))

(deftest move-santa-test
    (testing "Get santa position"
        (testing "without moving him"
            (is (= 0 (move-santa ""))))
        (testing "after one floor up"
            (is (= 1 (move-santa "("))))
        (testing "after one floor down"
            (is (= -1 (move-santa ")"))))
        (testing "after some moves"
            (is (= 0 (move-santa "(())"))))))
