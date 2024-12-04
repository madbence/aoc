(ns aoc.core
  (:require [clojure.string :as str]))

(defn ->int
  "Parse `n` via `Integer/parseInt`"
  [n]
  (Integer/parseInt n))

(defn split-words
  "Split `s` along whitespaces"
  [s]
  (str/split s #"\s+"))

(def split-lines str/split-lines)

(defn transpose
  "Flips `mx`"
  [mx]
  (apply map vector mx))

(defn map-mx
  "Map matrix `mx` via `f`"
  [f mx]
  (map #(map f %) mx))
