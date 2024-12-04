(ns aoc.2024.04
  (:use [aoc.core]))

(def masks
  [[[0 0] [1 0] [2 0] [3 0]]   ; -
   [[0 0] [0 1] [0 2] [0 3]]   ; |
   [[0 0] [1 1] [2 2] [3 3]]   ; \
   [[3 0] [2 1] [1 2] [0 3]]]) ; /

(def mask'
  [[0 0] [1 1] [2 2] [2 0] [0 2]]) ; X

(defn extract-str
  [puzzle mask]
  (->> mask                     ; mask is [x y]
       (map #(get-in puzzle %)) ; extract chars
       (apply str)))            ; concat into string

(defn part-1 [input]
  (let [puzzle (-> input split-lines vec)]
    (->> (for [x (-> puzzle first count range)
               y (-> puzzle count range)
               mask masks]
           (map #(map + %1 %2) (repeat [x y]) mask))
         (map #(extract-str puzzle %))
         (filter #{"XMAS" "SAMX"})
         count)))

(defn part-2 [input]
  (let [puzzle (-> input split-lines vec)]
    (->> (for [x (-> puzzle first count range)
               y (-> puzzle count range)]
           (map #(map + %1 %2) (repeat [x y]) mask'))
         (map #(extract-str puzzle %))
         (filter #{"MASMS" "MASSM" "SAMMS" "SAMSM"})
         count)))
