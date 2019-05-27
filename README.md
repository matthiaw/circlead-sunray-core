# night-prompt-karaf-cmd-bundle

This is standalone-cone of the karaf-command-example (https://github.com/apache/karaf/tree/master/examples/karaf-command-example).

## Install 

Compile and add to maven repository with

```
mvn install
```

and install in karaf with

```
karaf@root > feature:repo-add mvn:org.rogatio.circlead.sunray/circlead-core-features/0.0.1-SNAPSHOT/xml 
karaf@root > feature:install circlead-core
```
