(ns cascading.core
  (:import [cascalog Util]
           [cascading.tuple Fields]
           [cascading.tap.hadoop Hfs]
           [cascading.scheme.hadoop TextLine]
           [java.util List ArrayList]
           [com.twitter.maple.tap StdoutTap MemorySourceTap]))

(defn collectify [obj]
  (if (or (sequential? obj)
          (instance? List obj))
    obj, [obj]))

(defn ^Fields fields
  "Returns the supplied object as an instance of Cascading Fields."
  [x]
  (cond (instance? Fields x) x
        (nil? x) Fields/NONE
        :else (let [coll (collectify x)]
                (if (empty? coll)
                  Fields/NONE
                  (->> coll
                       (map str)
                       (into-array String)
                       (Fields.))))))

(defn memory-tap
  "Returns an instance of MemorySourceTap that produces the supplied
  clojure sequence on execution."
  ([tuples] (memory-tap tuples Fields/ALL))
  ([tuples fields-in]
     (let [tuples (->> tuples
                       (map #(Util/coerceToTuple %))
                       (ArrayList.))]
       (MemorySourceTap. tuples (fields fields-in)))))

(defn stdout
  "Creates a tap that prints tuples sunk to it to standard
   output. Useful for experimentation in the REPL."
  []
  (StdoutTap.))

(defn text-line
  ([] (TextLine.))
  ([field-names]
     (text-line field-names field-names))
  ([source-fields sink-fields]
     (TextLine. (fields source-fields)
                (fields sink-fields))))

(defn hfs [scheme path]
  (Hfs. scheme path))

(comment
  "Make a memory tap like this:"
  (memory-tap [1 2 3])

  "And a textline tap like this:"
  (hfs (text-line) "/tmp/outputpath")

  "Now, it's up to you to wire these bastards together :)"
  )
