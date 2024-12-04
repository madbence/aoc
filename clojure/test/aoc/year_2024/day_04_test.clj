(ns aoc.year-2024.day-04-test
  (:use clojure.test
        aoc.year-2024.day-04))

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

(deftest test-a
  (is (= (a fixture) 18)))

(deftest test-b
  (is (= (b fixture) 9)))
