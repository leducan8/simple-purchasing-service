package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.domain.model.Sql019_01DtoProjection;
import com.fleta.purchasingservice.port.SetPurchaseForRedisRepository;
import com.fleta.purchasingservice.port.SetPurchaseForRedisService;
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
    public List<Sql019_01DtoProjection> getSQL019_01List() {
        return setPurchaseForRedisRepository.nxvod211TobeSql01901();
    }
}
