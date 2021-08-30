package com.fleta.purchasingservice.port.service;

import com.fleta.purchasingservice.domain.dto.PurchaseRedisDtoProjection;

import java.util.List;

public interface SetPurchaseForRedisService {
    List<PurchaseRedisDtoProjection> getSQL019_01List();
}
