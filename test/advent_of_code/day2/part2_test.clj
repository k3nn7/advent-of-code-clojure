(ns advent-of-code.day2.part2-test
    (:require [clojure.test :refer :all]
              [advent-of-code.day2.part2 :refer :all]))

(deftest calc-ribbon-amount-test
    (testing "Calculate required ribbon amount"
        (testing "for 2x3x4"
            (is (= 34 (calc-ribbon-amount 2 3 4)))))
    (testing "Calculate required ribbon amount"
        (testing "for 10x1x1"
            (is (= 14 (calc-ribbon-amount 10 1 1))))))
