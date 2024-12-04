(ns aoc.2024.04-test
  (:use clojure.test
        aoc.2024.04))

(def fixture "MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX")

(deftest test-part-1
  (is (= (part-1 fixture) 18)))

(deftest test-part-2
  (is (= (part-2 fixture) 9)))
