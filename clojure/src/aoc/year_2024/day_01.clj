(ns aoc.year-2024.day-01
  (:use [aoc.core]))

(defn a [input]
  (->> input
       split-lines          ; split input by newlines
       (map split-words)    ; split each line by words
       (map-mx ->int)       ; parse each number in each line
       transpose            ; flip
       (map sort)           ; sort each columns
       transpose            ; flip back
       (map #(apply - %))   ; calculate difference between pairs
       (map abs)            ; take distance based on difference
       (reduce +)))         ; sum up distances

(defn b [input]
  (let [[left right] (->> input                ; same as before, but separate the left and right columns
                          split-lines
                          (map split-words)
                          (map-mx ->int)
                          transpose)
        freqs (frequencies right)]             ; count occurences in the right column
    (->> left
         (map #(* % (get freqs % 0)))          ; calculate similarity score for each number in the left column
         (reduce +))))                         ; sum up similarity scores
