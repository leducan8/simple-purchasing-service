package com.fleta.purchasingservice.port.service;

import com.fleta.purchasingservice.domain.dto.PurchaseRedisDtoProjection;

import java.util.List;
import java.util.Map;

public interface RedisSqlDtoService {
    void setList(Map<String, List<String>> map);

    Map<String, List<String>> groupBySaId(List<PurchaseRedisDtoProjection> purchaseRedisDtoProjectionList);
}
