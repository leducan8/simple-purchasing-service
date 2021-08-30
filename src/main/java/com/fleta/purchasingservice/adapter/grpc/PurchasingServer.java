package com.fleta.purchasingservice.adapter.grpc;

import com.fleta.purchasingservice.domain.service.PurchaseGrpcServiceImpl;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PurchasingServer implements ApplicationRunner {

    @Value("${grpc.port}")
    public int port;

    @Autowired
    private PurchaseGrpcServiceImpl purchasingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ServerBuilder.forPort(port)
                .addService(purchasingService)
                .build().start();
    }
}
