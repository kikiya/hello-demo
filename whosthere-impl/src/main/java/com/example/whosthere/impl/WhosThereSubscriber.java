package com.example.whosthere.impl;

import akka.Done;
import akka.stream.javadsl.Flow;
import com.example.hello.api.HelloEvent;
import com.example.hello.api.HelloService;
import com.example.whosthere.api.WhosThereService;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

/**
 * Created by kiki on 4/26/17.
 */
public class WhosThereSubscriber {

    @Inject
    public WhosThereSubscriber(HelloService helloService, WhosThereRepository repository) {
        // Create a subscriber
        helloService.helloEvents().subscribe()
                // And subscribe to it with at least once processing semantics.
                .atLeastOnce(
                        // Create a flow that emits a Done for each message it processes
                        Flow.<HelloEvent>create().mapAsync(1, event -> {

                            if (event instanceof HelloEvent.GreetingMessageChanged) {
                                HelloEvent.GreetingMessageChanged messageChanged = (HelloEvent.GreetingMessageChanged) event;
                                // Update the message
                                return repository.addGuest(messageChanged.getName(), messageChanged.getMessage());

                            } else {
                                // Ignore all other events
                                return CompletableFuture.completedFuture(Done.getInstance());
                            }
                        })
                );

    }
}
