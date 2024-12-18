(ns aoc.2024.01
  (:use [aoc.core]))

(defn parse [input]
  (->> input
       split-lines            ; split input by newlines
       (map split-words)      ; split each line by words
       (map-mx parse-long)))  ; parse each number in each line

(defn part-1 [input]
  (->> input
       parse
       transpose            ; flip
       (map sort)           ; sort each columns
       transpose            ; flip back
       (map #(apply - %))   ; calculate difference between pairs
       (map abs)            ; take distance based on difference
       (reduce +)))         ; sum up distances

(defn part-2 [input]
  (let [[left right] (->> input                ; same as before, but separate the left and right columns
                          parse
                          transpose)
        freqs (frequencies right)]             ; count occurences in the right column
    (->> left
         (map #(* % (get freqs % 0)))          ; calculate similarity score for each number in the left column
         (reduce +))))                         ; sum up similarity scores
