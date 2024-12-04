(ns aoc.year-2024.day-02-test
  (:use [aoc.year-2024.day-02]
        [clojure.test]))

(def fixture "7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9")

(deftest test-a
  (is (= (a fixture) 2)))

(deftest test-b
  (is (= (b fixture) 4)))
