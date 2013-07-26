(ns cascading.core-test
  (:use cascading.core
        midje.sweet)
  (:import [cascading.tuple Fields]))

(fact "addition works!"
  (+ 2 2) => 4)

(fact "Fields performs accurately"
  (fields nil) => Fields/NONE)
