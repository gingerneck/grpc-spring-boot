package com.neckcode.service;

import com.neckcode.grpcproto.HelloServicesGrpc;
import com.neckcode.grpcproto.HelloServicesRequest;
import com.neckcode.grpcproto.HelloServicesResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class SayToSomethingService extends HelloServicesGrpc.HelloServicesImplBase {
    private static final Logger logger = LoggerFactory.getLogger(SayToSomethingService.class);

    @Override
    public void helloService(HelloServicesRequest request, StreamObserver<HelloServicesResponse> responseObserver) {
        HelloServicesResponse setResponseMessage = HelloServicesResponse.newBuilder()
                .setMessage("Hello " + request.getMessage() + " my dear service!").build();
        logger.info(String.format("%1s sent a message: %1s", request.getName(),request.getMessage()));
        responseObserver.onNext(setResponseMessage);
        responseObserver.onCompleted();
    }
}
