package com.fleta.purchasingservice.port;

import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.domain.model.PurchasingProjection;

import java.util.List;

public interface CommonRepository {
    List<PurchasingDto> nxvod211TobeSql01901(String cSaId);
}
