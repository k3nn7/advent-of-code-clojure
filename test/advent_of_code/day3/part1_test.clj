(ns advent-of-code.day3.part1-test
    (:require [clojure.test :refer :all]
              [advent-of-code.day3.part1 :refer :all]))

(def some-houses
    [{:x 1 :y 1 :visits 10} {:x 2 :y 2 :visits 5}])

(deftest visit-house-test
    (testing "Visit"
        (testing "first house"
            (is (= [{:x 1 :y 1 :visits 1}]
                   (visit-house [] [1 1]))))
        (testing "second house"
            (is (= [{:x 1 :y 1 :visits 1} {:x 2 :y 1 :visits 1}]
                   (visit-house [{:x 1 :y 1 :visits 1}] [2 1]))))
        (testing "same house twice"
            (is (= [{:x 1 :y 1 :visits 2}]
                   (visit-house [{:x 1 :y 1 :visits 1}] [1 1]))))))

(deftest inc-visits-test
    (testing "Increment visits"
        (testing "of expected house"
            (is (= {:x 1 :y 1 :visits 2}
                   ((inc-visits 1 1) {:x 1 :y 1 :visits 1}))))
        (testing "of unexpected house"
            (is (= {:x 1 :y 1 :visits 1}
                   ((inc-visits 2 2) {:x 1 :y 1 :visits 1}))))))

(deftest visited?-test
    (testing "Was house visited"
        (testing "that exisits"
            (is (= true
                   (visited? some-houses 2 2))))
        (testing "that not exists"
            (is (= false (visited? some-houses 5 4))))))

(deftest move-test
    (testing "Move"
        (testing ">"
            (is (= [1 0]
                   (move [0 0] \>))))
        (testing "<"
            (is (= [-1 0]
                   (move [0 0] \<))))
        (testing "^"
            (is (= [0 1]
                   (move [0 0] \^))))
        (testing "v"
            (is (= [0 -1]
                   (move [0 0] \v))))))

(deftest visit-given-houses-test
    (testing "Visit given houses"
        (testing "for no commands"
            (is (= [[0 0] [{:x 0 :y 0 :visits 1}]]
                   (visit-given-houses ""))))
        (testing "for >"
            (is (= [[1 0] [{:x 0 :y 0 :visits 1} {:x 1 :y 0 :visits 1}]]
                   (visit-given-houses ">"))))
        (testing "for ><"
            (is (= [[0 0] [{:x 0 :y 0 :visits 2} {:x 1 :y 0 :visits 1}]]
                   (visit-given-houses "><"))))
        ))

(deftest count-visited-houses-test
    (testing "Count visited houses"
        (testing "for no commands"
            (is (= 1
                   (count-visited-houses (visit-given-houses "")))))
        (testing "for ><"
            (is (= 2
                   (count-visited-houses (visit-given-houses "><")))))
        (testing "for ^v^v^v^v^v"
            (is (= 2
                   (count-visited-houses (visit-given-houses "^v^v^v^v^v")))))
        (testing "for ^>v<"
            (is (= 4
                   (count-visited-houses (visit-given-houses "^>v<")))))
        ))
