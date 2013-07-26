# cascading-fields

The Scalding Fields API in Clojure!

## Hints

Fire up a clojure REPL with:

```bash
lein repl
```

Test that everything is working by running a few commands:

```clojure
REPL-y 0.1.9
Clojure 1.5.1
    Exit: Control+D or (exit) or (quit)
Commands: (user/help)
    Docs: (doc function-name-here)
          (find-doc "part-of-name-here")
  Source: (source function-name-here)
          (user/sourcery function-name-here)
 Javadoc: (javadoc java-object-or-class-here)
Examples from clojuredocs.org: [clojuredocs or cdoc]
          (user/clojuredocs name-here)
          (user/clojuredocs "ns-here" "name-here")
user=> (use 'cascading.core)
nil
user=> (memory-tap [1 2 3])
#<MemorySourceTap MemorySourceTap["MemorySourceScheme[[UNKNOWN]->[ALL]]"]["/177e2fa8-8a5c-47c4-b99c-9ad0531202ad"]"]>
```

The `cascading.core` namespace has the basic commands you'll need to get started.

I've also included the basic `ClojureMap`, `ClojureFilter` and `ClojureMapCat` java classes so you won't have to worry about Clojure function serialization. Instantiate them like this:

```clojure
user=> (import 'cascalog.ClojureMap)
cascalog.ClojureMap
user=> (ClojureMap. (fields "face") +)
#<ClojureMap ClojureMap[decl:'face']>
```

Once you build your `JobConf`, you'll need to include `"cascalog.hadoop.ClojureKryoSerialization"` in your `"io.serializations"` entry, just like Scalding.
