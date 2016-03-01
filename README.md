# parse-names

Very thin Clojure wrapper around
[Apache Commons Text](https://commons.apache.org/sandbox/commons-text/apidocs/org/apache/commons/text/names/HumanNameParser.html)

## Usage

```clj
(require '[parse-name.core :refer [parse-name]])

(parse-name "J. Walter Weatherman")
;; => {:first-name "Walter", :last-name "Weatherman", :leading-initial "J."}

(parse-name "de la Cruz, Ana M.")
;; => {:first-name "Ana", :last-name "de la Cruz", :middle-name "M."}

(parse-name "James C. ('Jimmy') O'Dell, Jr.")
;; => {:first-name "James", :last-name "O'Dell",
       :nick-name "Jimmy", :suffix "Jr.", :middle-name "C."}

```
## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
