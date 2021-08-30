package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.port.repository.RedisPurchaseRepository;
import com.fleta.purchasingservice.domain.dto.PurchaseRedisDtoProjection;
import com.fleta.purchasingservice.port.service.RedisSqlDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseRedisServiceImpl implements RedisSqlDtoService {

    @Autowired
    private RedisPurchaseRepository redisPurchaseRepository;


    @Override
    public void setList(Map<String, List<String>> map) {
        redisPurchaseRepository.setList(map);
    }

    @Override
    public Map<String, List<String>> groupBySaId(List<PurchaseRedisDtoProjection> purchaseRedisDtoProjectionList) {
        return redisPurchaseRepository.groupBySaId(purchaseRedisDtoProjectionList);
    }
}
