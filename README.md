# parse-names

Very thin Clojure(Script) wrapper around
[Apache Commons Text](https://commons.apache.org/sandbox/commons-text/apidocs/org/apache/commons/text/names/HumanNameParser.html)
and the [JavaScript Name Parser](https://github.com/joshfraser/JavaScript-Name-Parser).

**WARNING: The Clojure and ClojureScript behavior are different, see
  the examples for more info**
  
## Clojars Link
https://clojars.org/parse-names

## Usage from Clojure

```clj
(require '[parse-name.core :refer [parse-name]])

(parse-name "J. Walter Weatherman")
;; => {:first-name "Walter", :last-name "Weatherman", :leading-initial "J."}

(parse-name "de la Cruz, Ana M.")
;; => {:first-name "Ana", :last-name "de la Cruz", :middle-name "M."}

(parse-name "James C. ('Jimmy') O'Dell, Jr.")
;; => {:first-name "James", :last-name "O'Dell",
;;     :nick-name "Jimmy", :suffix "Jr.", :middle-name "C."}

```

## Usage from Clojure(Script)

```clj
(require '[parse-name.core :refer [parse-name]])

(parse-name "J. Walter Weatherman")
;; => {:first-name "Walter", :last-name "Weatherman", :initials "J."}

(parse-name "de la Cruz, Ana M.")
;; => **{:first-name "De", :last-name "La Cruz, Ana M."}**

(parse-name "James C. ('Jimmy') O'Dell, Jr.")
;; => {:first-name "James", :last-name "O'Dell,", :suffix "Jr", :initials "C."}
```

## License

Copyright © 2016 Sebastian Bensusan

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
