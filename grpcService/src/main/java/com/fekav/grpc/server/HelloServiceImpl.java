package com.fekav.grpc.server;

import com.fekav.grpc.HelloRequest;
import com.fekav.grpc.HelloResponse;
import com.fekav.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    private static final Logger log = Logger.getLogger(HelloServiceImpl.class.getName());

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        log.info("received " + request);
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hi " + request.getFirstName() + " " + request.getLastName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
