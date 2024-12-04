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
  (loop [mx mx                              ; mx is consumed column-by-column
         mx' []]                            ; mx' is the flipped matrix that is built row-by-row
    (if (-> mx first empty?)                ; when there are no columns left, we're done
      mx'
      (recur (map rest mx)                  ; drop the first colum
             (conj mx' (mapv first mx)))))) ; append the first column as a row to the flipped matrix
