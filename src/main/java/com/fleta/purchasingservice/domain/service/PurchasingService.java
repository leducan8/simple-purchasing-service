package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.domain.model.PurchasingProjection;
import com.fleta.purchasingservice.grpc.common.PurchasingInput;
import com.fleta.purchasingservice.grpc.common.PurchasingOutput;
import com.fleta.purchasingservice.grpc.common.PurchasingServiceGrpc;
import com.fleta.purchasingservice.port.CommonRepository;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PurchasingService extends PurchasingServiceGrpc.PurchasingServiceImplBase  {

    private CommonRepository commonRepository;

    public PurchasingService(CommonRepository commonRepository) {
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
        List<PurchasingProjection> purchasingDtoFlux = commonRepository.nxvod211TobeSql01901(input.getCSaId());
        List<PurchasingDto> returnList = new ArrayList<>();
        purchasingDtoFlux.forEach(item ->{
            returnList.add(new PurchasingDto(item.getProductId(),item.getExpiredDate()));
        });
        return returnList;
    }
}

