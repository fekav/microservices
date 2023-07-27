package com.fekav.grpc.server;

import com.fekav.grpc.HelloRequest;
import com.fekav.grpc.HelloResponse;
import com.fekav.grpc.HelloServiceGrpc;
import com.fekav.grpc.HelloServiceGrpc.HelloServiceBlockingStub;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    private final HelloServiceBlockingStub blockingStub;

    // for async stub
//    private final HelloServiceGrpc.HelloServiceStub asyncStub;

    public HelloClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = HelloServiceGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args) {
        HelloClient client = new HelloClient("localhost", 8088);
        HelloResponse response = client.blockingStub.hello(HelloRequest.newBuilder()
                        .setFirstName("Fevzi")
                        .setLastName("Kavalci").build());
        System.out.println(response.getGreeting());

    }

}
