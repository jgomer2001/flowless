# Flowless (playground)

A prototype webapp that helps manage flow assets (flows specification, actions code, UI fragments). In the future, a tool to compose, validate, and trigger flow execution.

## Requisites

Java 11, maven, Jetty 9.4
Setting up this app requires an existing Jetty base

## Setup

Edit web.xml's `base-path` context param accordingly

Edit this line if necessary: https://github.com/jgomer2001/flowless/blob/main/playground/src/main/java/org/gluu/flowless/playground/flows/FlowDetailVM.java#L22

Generate war: `mvn package`

Deploy

App's log is `playground.log`, see log4j2.xml
