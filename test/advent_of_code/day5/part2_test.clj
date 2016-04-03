(ns advent-of-code.day5.part2-test
    (:require [clojure.test :refer :all]
              [advent-of-code.day5.part2 :refer :all]))

(deftest get-all-pairs-test
    (testing "Get all pairs for abcde:"
        (is (= ["ab" "cd" "de" "bc"]
               (get-all-pairs "abcde")))
        (is (= ["aa"]
               (get-all-pairs "aaa")))
        ))

(deftest count-substring-test
    (testing "Count substring occurences in string"
        (is (= 2 (count-substring "ababa" "ab")))
        (is (= 1 (count-substring "ababa" "aba")))
        (is (= 1 (count-substring "foobar" "foo")))
        ))

(deftest count-pairs-test
    (testing "Count pairs"
        (is (= {"ab" 2 "ba" 1}
               (count-pairs "abab")))
        (is (= {"ab" 2 "ba" 2}
               (count-pairs "ababa")))
        (is (= {"aa" 1}
               (count-pairs "aaa")))
        ))

(deftest has-double-double?-test
    (testing "Has double-double?"
        (is (= true (has-double-double? "xxyxx")))
        (is (= true (has-double-double? "aabcdefgaa")))
        (is (= false (has-double-double? "aaa")))
        (is (= false (has-double-double? "abba")))))

(deftest has-triple?-test
    (testing "Has triple"
        (is (= true (has-triple? "xyx")))
        (is (= true (has-triple? "aaa")))
        (is (= true (has-triple? "xxyxx")))
        (is (= false (has-triple? "abc")))
        ))

(deftest nice?-test
    (testing "Is given string nice?"
        (testing "qjhvhtzxzqqjkmpb"
            (is (= true (nice? "qjhvhtzxzqqjkmpb"))))
        (testing "xxyxx"
            (is (= true (nice? "xxyxx"))))
        (testing "uurcxstgmygtbstg"
            (is (= false (nice? "uurcxstgmygtbstg"))))
        (testing "ieodomkazucvgmuy"
            (is (= false (nice? "ieodomkazucvgmuy"))))
        ))

(deftest count-nice-strings-test
    (testing "Count nice strings"
        (is (= 2
              (count-nice-strings "qjhvhtzxzqqjkmpb\nuurcxstgmygtbstg\nxxyxx\n")))))
