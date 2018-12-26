package com.github.jeanadrien.gatling.mqtt.protocol

import akka.actor.{ActorRef, ActorSystem}
import com.github.jeanadrien.gatling.mqtt.client.MqttClient
import com.typesafe.scalalogging.StrictLogging
import io.gatling.commons.validation.Validation
import io.gatling.core.protocol.ProtocolComponents
import io.gatling.core.session._

/**
  *
  */
case class MqttComponents(
    mqttProtocol : MqttProtocol, system : ActorSystem
) extends ProtocolComponents with StrictLogging {

    def mqttEngine(
        session : Session, connectionSettings : ConnectionSettings, gatlingMqttId : String
    ) : Validation[ActorRef] = {
        logger.debug(s"MqttComponents: new mqttEngine: $gatlingMqttId")
        mqttProtocol.configureMqtt(session).map { config =>
            // inject the selected engine
            val mqttClient = system.actorOf(MqttClient.clientInjection(config, gatlingMqttId))
            mqttClient
        }
    }



    override def onStart : Session => Session = s => {
        logger.debug("MqttComponents: onStart")
        s
    }

    override def onExit : Session => Unit = s => {
        logger.debug("MqttComponents: onExit")
        s("engine").asOption[ActorRef].foreach { mqtt =>
            system.stop(mqtt)
        }
    }
}
