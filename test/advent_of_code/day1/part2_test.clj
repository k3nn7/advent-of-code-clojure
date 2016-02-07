(ns advent-of-code.day1.part2-test
    (:require [clojure.test :refer :all]
              [advent-of-code.day1.part2 :refer :all]))

(deftest when-enters-enters-basement-test
    (testing "When santa enters basement"
        (testing "if first goes down"
            (is (= 1 (when-enters-basement ")"))))
        (testing "if does some moves"
            (is (= 5 (when-enters-basement "()())"))))))
