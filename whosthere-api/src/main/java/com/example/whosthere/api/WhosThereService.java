package com.example.whosthere.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.topic;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.kafka.KafkaProperties;

import java.util.List;

/**
 * Created by kiki on 4/26/17.
 */
public interface WhosThereService extends Service {

    /**
     * Example: curl http://localhost:9000/api/whosthere
     */
    ServiceCall<NotUsed, List<Guest>> whosthere();

    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("hello").withCalls(
                pathCall("/api/whosthere",  this::whosthere)
        ).withAutoAcl(true);
        // @formatter:on
    }
}
