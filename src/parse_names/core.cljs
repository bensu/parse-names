(ns parse-names.core
  (:require [parse-names.vendor :as v]))

(defn parse-name [name]
  (let [name-obj (v/parse name)]
    (->> {:first-name (.-firstName name-obj)
          :last-name (.-lastName name-obj)
          :leading-initial (.-salutation name-obj)
          :suffix (.-suffix name-obj)
          :middle-name (.-initials name-obj)}
         (filter (fn [[k v]] (not (empty? v))))
         (into {}))))
