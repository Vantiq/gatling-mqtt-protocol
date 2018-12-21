package com.github.jeanadrien.gatling.mqtt.client

import com.github.jeanadrien.gatling.mqtt.client.MqttQoS.MqttQoS
import com.github.jeanadrien.gatling.mqtt.protocol.{MqttProtocolReconnectPart, MqttProtocolSocketPart, MqttProtocolThrottlingPart}
import org.fusesource.mqtt.client.QoS._

/**
  * Concrete configuration after being generated by the Expression
  */
case class MqttClientConfiguration(
    host : String = "localhost",
    clientId         : Option[String] = None,
    cleanSession     : Boolean = true,
    username         : Option[String] = None,
    password         : Option[String] = None,
    will             : Option[Will] = None,
    keepAlive        : Int = 30, // seconds
    version          : Option[String] = None, // default 3.1
    reconnectConfig  : MqttProtocolReconnectPart = MqttProtocolReconnectPart(),
    socketConfig     : MqttProtocolSocketPart = MqttProtocolSocketPart(),
    throttlingConfig : MqttProtocolThrottlingPart = MqttProtocolThrottlingPart()
)

case class Will(
    topic : String,
    message    : String, // Array[Byte],
    qos        : MqttQoS = MqttQoS.AtMostOnce,
    willRetain : Boolean = false // TODO : Check default value
)

