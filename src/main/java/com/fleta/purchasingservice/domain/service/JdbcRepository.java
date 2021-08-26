package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.domain.model.PurchasingProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.port.PurchaseRepository;
import com.fleta.purchasingservice.port.CommonRepository;

import java.util.List;

/**
 * The class is an use case implementation of the inbound port.
 */
@Service
public class JdbcRepository implements CommonRepository {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<PurchasingProjection> nxvod211TobeSql01901(String cSaId) {
        return purchaseRepository.nxvod211TobeSql01901(cSaId);
    }
}
