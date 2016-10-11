(ns parse-names.core
  (:require [parse-names.vendor :as v]))

(defn parse-name [name]
  (let [name-obj (v/parse name)]
    (->> {:first-name (aget name-obj "firstName")
          :last-name (aget name-obj "lastName")
          :salutation (aget name-obj "salutation")
          :suffix (aget name-obj "suffix")
          :initials (aget name-obj "initials")}
         (filter (fn [[k v]] (not (empty? v))))
         (into {}))))
