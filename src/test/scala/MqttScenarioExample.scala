import com.github.jeanadrien.gatling.mqtt.Predef._
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

/**
  *
  */
class MqttScenarioExample extends Simulation {

    val mqttConf = mqtt.host("tcp://localhost:1883")

    val scn = scenario("MQTT Test")
        .exec(connect)
        .exec(subscribe("myTopic"))
        .during(30 seconds) {
            pace(1 second).exec(publish("myTopic", "myPayload"))
        }

    setUp(
        scn.inject(rampUsers(10) during (10 seconds)))
        .protocols(mqttConf)
}
