package com.neckcode.service;

import com.neckcode.grpcproto.HelloServicesGrpc;
import com.neckcode.grpcproto.HelloServicesRequest;
import com.neckcode.grpcproto.HelloServicesResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    @GrpcClient("grpc-server")
    private HelloServicesGrpc.HelloServicesBlockingStub helloServicesBlockingStub;

    public void sayHello(String sender, String message) {
        HelloServicesRequest request = HelloServicesRequest.newBuilder().setName(sender)
                .setMessage(message).build();
        HelloServicesResponse response = this.helloServicesBlockingStub.helloService(request);
        logger.info(String.format("Server sent a response: %1s", response.getMessage()));
    }
}
