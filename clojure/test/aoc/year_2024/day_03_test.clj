(ns aoc.year-2024.day-03-test
  (:use aoc.year-2024.day-03
        clojure.test))

(def fixture "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")
(def fixture' "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")

(deftest test-a
  (is (= (a fixture) 161)))

(deftest test-b
  (is (= (b fixture') 48)))
