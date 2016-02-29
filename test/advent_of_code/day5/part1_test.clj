(ns advent-of-code.day5.part1-test
    (:require [clojure.test :refer :all]
              [advent-of-code.day5.part1 :refer :all]))

(deftest is-nice?-test
    (testing "Is nice:"
        (testing "ugknbfddgicrmopn"
            (is (= true (nice? "ugknbfddgicrmopn"))))
        (testing "aaa"
            (is (= true (nice? "aaa"))))
        )
    (testing "Is naughty:"
        (testing "jchzalrnumimnmhp"
            (is (= false (nice? "jchzalrnumimnmhp"))))
        (testing "haegwjzuvuyypxyu"
            (is (= false (nice? "haegwjzuvuyypxyu"))))
        (testing "dvszwmarrgswjxmb"
            (is (= false (nice? "dvszwmarrgswjxmb"))))
        ))

(deftest count-nice-strings-test
    (testing "Count nice strings"
        (is (= 2
              (count-nice-strings "ugknbfddgicrmopn\naaa\njchzalrnumimnmhp\n")))))
