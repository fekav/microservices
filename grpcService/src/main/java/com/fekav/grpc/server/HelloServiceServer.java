package com.fekav.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HelloServiceServer {
    private static final Logger log = Logger.getLogger(HelloServiceServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8088).addService(new HelloServiceImpl()).build();
        log.info("Starting server...");
        server.start();
        log.info("Server started. It will wait 3 minute for termination.");
        server.awaitTermination(3L, TimeUnit.MINUTES);
    }



}
