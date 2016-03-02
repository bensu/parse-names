(ns parse-names.core
  (:import [org.apache.commons.text.names HumanNameParser]
           [org.apache.commons.text.names Name]))

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
