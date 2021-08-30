package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.grpc.common.PurchasingInput;
import com.fleta.purchasingservice.grpc.common.PurchasingOutput;
import com.fleta.purchasingservice.grpc.common.PurchasingServiceGrpc;
import com.fleta.purchasingservice.port.repository.CommonRepository;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PurchaseGrpcServiceImpl extends PurchasingServiceGrpc.PurchasingServiceImplBase {

    private CommonRepository commonRepository;

    public PurchaseGrpcServiceImpl(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }

    @Override
    public void nxvod211TobeSql01901(PurchasingInput request, StreamObserver<PurchasingOutput> responseObserver) {
        List<PurchasingDto> list = getNxvod211TobeSql01901Data(request);
        list.stream()
                .map(PurchasingDto::toPurchasingOutput)
                .forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    public List<PurchasingDto> getNxvod211TobeSql01901Data(PurchasingInput input) {
        return commonRepository.nxvod211TobeSql01901(input.getCSaId());
    }
}

