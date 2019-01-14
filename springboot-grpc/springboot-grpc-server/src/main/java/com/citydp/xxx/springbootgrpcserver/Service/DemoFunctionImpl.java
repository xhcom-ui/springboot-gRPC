package com.citydp.xxx.springbootgrpcserver.Service;

import com.citydo.xxx.DemoProtobuf;
import com.citydo.xxx.DemoServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import sun.awt.SunHints;

@GrpcService(DemoServiceGrpc.class)
public class DemoFunctionImpl extends DemoServiceGrpc.DemoServiceImplBase {
    @Override
    public void demoFunction(DemoProtobuf.DemoInput request, StreamObserver<DemoProtobuf.DemoOutput> responseObserver){
        final DemoProtobuf.DemoOutput.Builder outputBuilder = DemoProtobuf.DemoOutput.newBuilder().setKey("Hello "+ request.getKey());
        responseObserver.onNext(outputBuilder.build());
        responseObserver.onCompleted();
    }
}
