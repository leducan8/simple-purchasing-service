package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.port.repository.SetPurchaseForRedisRepository;
import com.fleta.purchasingservice.domain.dto.PurchaseRedisDtoProjection;
import com.fleta.purchasingservice.port.service.SetPurchaseForRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The class is an use case implementation of the inbound port.
 */
@Service
public class SetPurchaseForRedisServiceImpl implements SetPurchaseForRedisService {

    @Autowired
    private SetPurchaseForRedisRepository setPurchaseForRedisRepository;

    @Override
    public List<PurchaseRedisDtoProjection> getSQL019_01List() {
        return setPurchaseForRedisRepository.nxvod211TobeSql01901();
    }
}
