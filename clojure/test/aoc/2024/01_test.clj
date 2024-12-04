(ns aoc.2024.01-test
  (:use [aoc.2024.01]
        [clojure.test]))

(def fixture "3   4
4   3
2   5
1   3
3   9
3   3")

(deftest test-part-1
  (is (= (part-1 fixture) 11)))

(deftest test-part-2
  (is (= (part-2 fixture) 31)))
