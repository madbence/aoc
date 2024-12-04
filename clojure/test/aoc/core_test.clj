(ns aoc.core-test
  (:use [clojure.test]
        [aoc.core]))

(deftest test-split-words
  (is (= (split-words "1 2 3") ["1" "2" "3"]))
  (is (= (split-words "123") ["123"])))

(deftest test-transpose
  (is (= (transpose [[1 2 3]
                     [4 5 6]
                     [7 8 9]])
                    [[1 4 7]
                     [2 5 8]
                     [3 6 9]]))
  (is (= (transpose [[1 1 1]
                     [2 2 2]
                     [3 3 3]
                     [4 4 4]])
                    [[1 2 3 4]
                     [1 2 3 4]
                     [1 2 3 4]]))
  (is (= (transpose [[1 1 1 1]
                     [2 2 2 2]
                     [3 3 3 3]])
                    [[1 2 3]
                     [1 2 3]
                     [1 2 3]
                     [1 2 3]])))

(deftest test-map-mx
  (is (= (map-mx inc [[1 2 3]
                      [4 5 6]])
                     [[2 3 4]
                      [5 6 7]])))
