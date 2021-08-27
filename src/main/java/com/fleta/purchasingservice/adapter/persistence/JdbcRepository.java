package com.fleta.purchasingservice.adapter.persistence;

import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.domain.model.PurchasingProjection;
import com.fleta.purchasingservice.port.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The class is an use case implementation of the inbound port.
 */
@Repository
@Primary
@ConditionalOnProperty(name = "repository-type", havingValue = "jdbc")
public class JdbcRepository implements CommonRepository {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<PurchasingDto> nxvod211TobeSql01901(String cSaId) {
        return purchaseRepository.nxvod211TobeSql01901(cSaId);
    }
}
