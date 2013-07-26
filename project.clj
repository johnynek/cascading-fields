(defproject cascading-fields "0.1.0-SNAPSHOT"
  :jvm-opts ["-Xmx768m"
             "-server"
             "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n"]
  :javac-options ["-target" "1.6" "-source" "1.6"]
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :repositories {"conjars" "http://conjars.org/repo/"}
  :exclusions [log4j/log4j org.slf4j/slf4j-log4j12]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [log4j "1.2.16"]
                 [org.slf4j/slf4j-log4j12 "1.6.6"]
                 [cascading/cascading-hadoop "2.0.8"
                  :exclusions [org.codehaus.janino/janino
                               org.apache.hadoop/hadoop-core]]
                 [cascading.kryo "0.4.6"]
                 [com.twitter/carbonite "1.3.2"]
                 [com.twitter/maple "0.2.2"]]
  :profiles {:provided {:dependencies [[org.apache.hadoop/hadoop-core "1.1.2"]]}
             :dev {:dependencies
                   [[org.apache.hadoop/hadoop-core "1.1.2"]]}})
