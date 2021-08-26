package com.fleta.purchasingservice.port;

import com.fleta.purchasingservice.domain.model.Sql019_01DtoProjection;

import java.util.List;

public interface SetPurchaseForRedisService {
    List<Sql019_01DtoProjection> getSQL019_01List();
}
