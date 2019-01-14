package com.citydo.xxx.springbootgrpcclient.Service;

import com.citydo.xxx.DemoProtobuf;
import com.citydo.xxx.DemoServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;


@Service
public class DemoService {

    @GrpcClient("springboot-grpc-server")
    private Channel channel;


    public String demoFunction(String name){
        DemoServiceGrpc.DemoServiceBlockingStub stub = DemoServiceGrpc.newBlockingStub(channel);
        DemoProtobuf.DemoOutput response = stub.demoFunction(DemoProtobuf.DemoInput.newBuilder().setKey(name).build());
        return response.getKey();
    }
}

