(ns aoc.2024.23
  (:use aoc.core)
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn groups [g]
  (set (for [a (-> g keys)
             b (g a)
             c (g b)
             :when (and (not= a c) ((g a) c))] #{a b c})))

(defn part-1 [input]
  (->> input
       split-lines
       (map (partial re-seq #"\w+"))
       (mapcat #(vector % (reverse %)))
       (reduce #(update %1 (first %2) (fn [p n] (if (nil? p) #{n} (conj p n))) (second %2)) {})
       groups
       (filter (partial some #(str/starts-with? % "t")))
       count))

(defn find-clique [g n]
  (loop [c #{n}]
    (if-let [n (->> g keys (remove c) (filter #(set/subset? c (g %))) first)]
      (recur (conj c n))
      c)))

(defn find-max-clique [g]
  (->> g
       keys
       (map (partial find-clique g))
       (reduce #(if (< (count %1) (count %2)) %2 %1))))

(defn part-2 [input]
  (->> input
       split-lines
       (map (partial re-seq #"\w+"))
       (mapcat #(vector % (reverse %)))
       (reduce #(update %1 (first %2) (fn [p n] (if (nil? p) #{n} (conj p n))) (second %2)) {})
       find-max-clique
       sort
       (str/join ",")))
