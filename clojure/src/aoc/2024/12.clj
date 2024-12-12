(ns aoc.2024.12
  (:use aoc.core))

(def corner-patterns
  {[0 0 0 0] 0
   [0 0 0 1] 3
   [0 0 1 0] 3
   [0 0 1 1] 0
   [0 1 0 0] 3
   [0 1 0 1] 0
   [0 1 1 0] 3 ;
   [0 1 1 1] 1
   [1 0 0 0] 3
   [1 0 0 1] 3 ;
   [1 0 1 0] 0
   [1 0 1 1] 1
   [1 1 0 0] 0
   [1 1 0 1] 1
   [1 1 1 0] 1
   [1 1 1 1] 0})

(defn up [[x y]] [x (dec y)])
(defn down [[x y]] [x (inc y)])
(defn left [[x y]] [(dec x) y])
(defn right [[x y]] [(inc x) y])

(defn masks [p]
  [[(-> p up left) (-> p up) (-> p left) p]
   [(-> p up) (-> p up right) p (-> p right)]
   [p (-> p right) (-> p down) (-> p down right)]
   [(-> p left) p (-> p left down) (-> p down)]])

(def neighbours (juxt up down left right))

(defn area [plots]
  (count plots))

(defn perimeter [plots]
  (->> plots
       (mapcat neighbours) ; replace every cell with its neighbours
       (remove plots)      ; remove cells that are within the original region
       count))

(defn region-score [plots]
  (* (area plots)
     (perimeter plots)))

(defn sides [plots]
  (/ (->> plots
          (mapcat masks)                                    ; generate 4 masks for every cell
          (map (fn [mask] (mapv #(if (plots %) 1 0) mask))) ; evaluate masks
          (map #(get corner-patterns %))                    ; evaluate how many corners are in every mask
          (reduce +))
     3)) ; some corners are found multiple times

(defn region-score' [plots]
  (* (area plots)
     (sides plots)))

(defn find-region [start plots]
  (loop [region #{}
         visited #{}
         queue [start]]
    (if-let [c (first queue)]
      (if (or (visited c)
              (not= (get-in plots start) (get-in plots c)))
        (recur region
               (conj visited c)
               (rest queue))
        (recur (conj region c)
               (conj visited c)
               (concat (rest queue) (neighbours c))))
      region))) ; when queue is empty, we found the region

(defn part-1 [input]
  (let [plots (->> input split-lines vec)
        w (-> plots first count)
        h (-> plots count)]
    (->> (for [x (range w)
               y (range h)]
           (find-region [x y] plots))
         (into #{})
         (map region-score)
         (reduce +))))

(defn part-2 [input]
  (let [plots (->> input split-lines vec)
        w (-> plots first count)
        h (-> plots count)]
    (->> (for [x (range w)
               y (range h)]
           (find-region [x y] plots))
         (into #{})
         (map region-score')
         (reduce +))))
