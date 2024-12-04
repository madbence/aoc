(ns aoc.year-2024.day-02
  (:use aoc.core))

(defn safe? [report]
  (let [diffs (map - report (rest report))] ; calculate differences between elements
    (and (every? #{-3 -2 -1 1 2 3} diffs)   ; report is safe when differences are in range AND
         (or (every? pos? diffs)            ; differences are either positive
             (every? neg? diffs)))))        ; OR negative

(defn variations [report]
  (->> 0
       (iterate inc)                         ; generate numbers from 0
       (take (count report))
       (map #(concat (take % report)         ; drop the nth element from report
                     (drop (inc %) report)))
       (into [report])))                     ; the original report counts as a report as well

(defn parse-report [input]
  (->> input
       split-lines
       (map split-words)
       (map-mx parse-long)))

(defn a [input]
  (->> input
       parse-report
       (filter safe?)
       count))

(defn b [input]
  (->> input
       parse-report
       (map variations)
       (filter #(some safe? %)) ; keep reports where some variations are safe
       count))
