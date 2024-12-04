(ns aoc.year-2024.day-01-test
  (:use [aoc.year-2024.day-01]
        [clojure.test]))

(def fixture "3   4
4   3
2   5
1   3
3   9
3   3")

(deftest test-a
  (is (= (a fixture) 11)))

(deftest test-b
  (is (= (b fixture) 31)))
