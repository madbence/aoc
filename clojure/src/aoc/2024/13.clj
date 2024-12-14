(ns aoc.2024.13
  (:use aoc.core))

(defn parse [g]
  (->> g (map #(->> % (re-seq #"\d+") (map parse-long)))))

(defn correct [[a b [px py]]]
  [a b [(+ 10000000000000 px)
        (+ 10000000000000 py)]])

;; a * ax + b * bx = px
;; a * ay + b * by = py
;; -- multiply 1st by `by` the second by `bx`
;; a * (ax * by) + b * (bx * by) = by * px
;; a * (ay * bx) + b * (by * bx) = bx * py
;; -- subtract 2nd from 1st
;; a * (ax * by - ay * bx) = by * px - bx * py
;; -- solve for a, then b
;; a = (by * px - bx * py) / (ax * by - ay * bx)
;; b = (px - a * ax) / bx

(defn solve [[[ax ay] [bx by] [px py]]]
  (let [a (/ (- (* px by) (* py bx))
             (- (* ax by) (* ay bx)))
        b (/ (- px (* a ax)) bx)]
    (if (and (integer? a) (integer? b))
      (+ b (* a 3))
      nil)))

(defn part-1 [input]
  (->> input
       split-lines
       (partition 3 4)
       (keep (comp solve parse))
       (reduce +)))

(defn part-2 [input]
  (->> input
       split-lines
       (partition 3 4)
       (keep (comp solve correct parse))
       (reduce +)))
