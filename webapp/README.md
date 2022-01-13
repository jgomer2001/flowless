# webapp

This is a placeholder webapp for the engine flow. There is no actual code here

In practice this app won't exist, see the `README` of engine folder

## Requisites

Java 11, maven, Jetty 9.4

Ensure you have `install`ed in your maven local repo the artifact `org.gluu.flowless:engine`. The corresponding Java project is in the `engine` folder. However, since "base folder" is hardcoded here:

https://github.com/jgomer2001/flowless/blob/main/engine/src/main/java/org/gluu/flowless/engine/model/EngineConfig.java

you'll have to adjust it beforehand. Change `/home/jgomer/Downloads/jetty/jetty-base` to an already existing location in your computer (ideally an empty folder) and leave the rest (that is, `/at`). 

## Setup

Generate war: `mvn package`

Adjust to suit your needs: 

`export JETTY_HOME=~/Downloads/jetty/jetty-distribution-9.4.35.v20201120` (the path where jetty is installed)

`cd <value of EngineConfig.ROOT_DIR>/..`

Then

```
java -jar $JETTY_HOME/start.jar --create-startd
java -jar $JETTY_HOME/start.jar --add-to-start=jsp,servlet,http,deploy,console-capture
cd webapps
```

copy the file `flowless_web_resources.xml` in the current directory and adjust `resourceBase` accordingly
copy the war file as well, or: `mkdir webapp && cd webapp && jar -xf path_to_war_file` (exploded strategy)

Back to the Jetty base (`cd ..`) copy the `at` folder (it's found alongside this README)

## Dissecting "at" directory

Inside `at` there is:

- `actions`: The existing actions
- `fl`: the parent path for all flow's assets
- `flows`: the flows themselves. 
- `scripts`: the root for the file-based Groovy script engine

Note that `flows` contains files of 3 kinds:

- <flow name> (extensionless): flow's coded in DSL
- <flow name>.json: flow's metadata
- <flow name>.js file: flow's transpiled code (only used by the engine, shouldn't be edited or displayed anywhere). See `engine` README to learn more

At the top level some default freemarker templates can be found as well as utility JS server-side code. 

## Setup the manager app

This component is not essential but allows to launch registered flows quickly instead of crafting urls by hand, and also to navigate the catalog of flows, actions, and assets.

Read the `playground` README for instructions.

## Play

`java -jar $JETTY_HOME/start.jar`

Visit the playground app, say `http://localhost:8080/playground/` and have fun

When running, there will be a general log (engine.log) and a flow's log (flow.log). The latter will contain only the log statements issued in DSL code (ie. `Log "Hello"`). See log4j.xml

Note flows run all under the url `http://localhost:8080/webapp/fl`
