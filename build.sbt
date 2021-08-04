organization := "com.github.jeanadrien"
name := "gatling-mqtt-protocol"

scalaVersion := "2.13.6"

licenses := Seq(
    "Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
)

homepage := Some(url("https://github.com/jeanadrien/gatling-mqtt-protocol"))

scmInfo := Some(
    ScmInfo(
        url("https://github.com/jeanadrien/gatling-mqtt-protocol"),
        "scm:git@github.com:jeanadrien/gatling-mqtt-protocol.git"
    )
)

developers := List(
    Developer(
        id    = "jeanadrien",
        name  = "Jean-Adrien Vaucher",
        email = "jean@jeanjean.ch",
        url   = url("https://github.com/jeanadrien")
    )
)

// dependencies
libraryDependencies += "io.gatling" % "gatling-core" % "3.6.1" % "provided"
libraryDependencies += "org.fusesource.mqtt-client" % "mqtt-client" % "1.16"
libraryDependencies += "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.2.2"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.6.1" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.6.1" % "test"

// for the gatling lib
assemblyOption in assembly := (assemblyOption in assembly).value
    .copy(includeScala = false)
