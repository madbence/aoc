(ns aoc.2024.12-test
  (:use aoc.2024.12
        clojure.test))

(def fixture "RRRRIICCFF
RRRRIICCCF
VVRRRCCFFF
VVRCCCJFFF
VVVVCJJCFE
VVIVCCJJEE
VVIIICJJEE
MIIIIIJJEE
MIIISIJEEE
MMMISSJEEE")

(deftest test-part-1
  (is (= (part-1 fixture) 1930)))

(deftest test-part-2
  (is (= (part-2 fixture) 1206)))
