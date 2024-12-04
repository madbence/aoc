(ns aoc.2024.03-test
  (:use aoc.2024.03
        clojure.test))

(def fixture "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")
(def fixture' "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")

(deftest test-part-1
  (is (= (part-1 fixture) 161)))

(deftest test-part-2
  (is (= (part-2 fixture') 48)))
