(ns aoc.year-2024.day-03
  (:use aoc.core))

(defn a [input]
  (->> input
       (re-seq #"mul\((\d+),(\d+)\)")
       (map rest)                     ; keep mul args
       (map-mx ->int)                 ; parse them as integer
       (map #(apply * %))             ; multiply them
       (reduce +)))                   ; sum them up

(defn b [input]
  (->> input
       (re-seq #"mul\((\d+),(\d+)\)|do\(\)|don't\(\)")         ; iterate over instructions
       (reduce (fn [[enabled acc] ins]
                 (case (nth ins 0)
                   "do()" [true acc]                           ; enable
                   "don't()" [false acc]                       ; disable
                   [enabled (if enabled (conj acc ins) acc)])) ; if disabled, discard
               [true []])                                      ; start with enabled
       second                                                  ; keep instructions (discard the accumulator flag)
       (map rest)                                              ; keep only mul args
       (map-mx ->int)                                          ; parse them as integer
       (map #(apply * %))                                      ; multiply them
       (reduce +)))                                            ; sum them up
