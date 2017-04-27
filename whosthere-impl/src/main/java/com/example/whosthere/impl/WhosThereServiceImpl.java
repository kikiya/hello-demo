package com.example.whosthere.impl;

import akka.NotUsed;
import com.example.hello.api.HelloService;
import com.example.whosthere.api.Guest;
import com.example.whosthere.api.WhosThereService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import javax.inject.Inject;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;

/**
 * Created by kiki on 4/26/17.
 */
public class WhosThereServiceImpl implements WhosThereService {

    private final WhosThereRepository repository;

    @Inject
    public WhosThereServiceImpl(WhosThereRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceCall<NotUsed, List<Guest>> whosthere() {
        //
    }


}
