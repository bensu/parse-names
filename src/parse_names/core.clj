(ns parse-names.core
  (:import [org.apache.commons.text.names HumanNameParser]
           [org.apache.commons.text.names Name])
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.set :as set]))

(def parser (HumanNameParser.))

(defn parse-name [s]
  (let [name-obj (.parse parser s)]
    (->> {:first-name (.getFirstName name-obj)
          :last-name (.getLastName name-obj)
          :leading-initial (.getLeadingInitial name-obj)
          :nick-name (.getNickName name-obj)
          :suffix (.getSuffix name-obj)
          :middle-name (.getMiddleName name-obj)}
         (filter (fn [[k v]] (not (empty? v))))
         (into {}))))


;; ======================================================================
;; Extract names out of a string

(def name-regex #"[A-Z]{1}[a-z]+\s[A-Z]{1}[a-z]+")

(defn read-names
  "Helper to parse names of a text file assuming they come line-separated"
  [file-str]
  (with-open [rdr (io/reader file-str)]
    (loop [lns (line-seq rdr)
           acc (sorted-set)]
      (if-let [next-line (first lns)]
        (recur (rest lns) (conj acc (-> next-line str/lower-case str/trim)))
        acc))))

(def all-names
  (into (sorted-set) (edn/read-string (slurp (io/resource "all-names.edn")))))
