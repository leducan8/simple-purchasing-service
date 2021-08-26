package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.domain.service.PurchasingService;
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
    private PurchasingService purchasingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ServerBuilder.forPort(port)
                .addService(purchasingService)
                .build().start();
    }
}
