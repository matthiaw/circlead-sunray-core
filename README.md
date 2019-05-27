# night-prompt-karaf-cmd-bundle

Compile and add to maven repository with

```
mvn install
```

and install in karaf with

```
karaf@root > feature:repo-add mvn:org.rogatio.circlead.sunray/circlead-core-features/0.0.1-SNAPSHOT/xml 
karaf@root > feature:install circlead-core
```
