(ns advent-of-code.day2.part1-test
    (:require [clojure.test :refer :all]
              [advent-of-code.day2.part1 :refer :all]))

(deftest calc-paper-amount-test
    (testing "Calculate required paper amount"
        (testing "for 2x3x4"
            (is (= 58 (calc-paper-amount 2 3 4))))
        (testing "for 1x1x10"
            (is (= 43 (calc-paper-amount 1 1 10))))))

(deftest parse-dimensions-test
    (testing "Parse dimensions"
        (testing "2x3x4"
            (is (= [2 3 4] (parse-dimensions "2x3x4"))))
        (testing "1x1x10"
            (is (= [1 1 10] (parse-dimensions "1x1x10"))))))

(deftest calc-total-amount-test
    (testing "Calc total amount"
        (is (= 101 (calc-total-amount "2x3x4\n1x1x10\n")))))
