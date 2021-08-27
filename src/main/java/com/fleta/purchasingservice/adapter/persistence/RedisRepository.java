package com.fleta.purchasingservice.adapter.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.domain.model.PurchasingProjection;
import com.fleta.purchasingservice.port.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RedisRepository implements CommonRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final PurchaseRepository purchaseRepository; // Optional
    private final String KEY_PREFIX_SQL019_01 = "Sql019_01:";

    @Autowired
    public RedisRepository(
            RedisTemplate<String, String> redisTemplate,
            PurchaseRepository purchaseRepository
    ) {
        this.redisTemplate = redisTemplate;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public List<PurchasingDto> nxvod211TobeSql01901(String cSaId) {
        // Redis 조회
        List<PurchasingDto> redisList = getFromRedisNxvod211TobeSql01901(cSaId);
        boolean nullsOnly = redisList.stream().allMatch(x -> x == null);
        if (nullsOnly) {
            // Redis에 없는 경우, RDB 조회
            redisList = purchaseRepository.nxvod211TobeSql01901(cSaId);
            // RDB에서 조회한 데이터를 Redis에 적재
            setToRedisNxvod211TobeSql01901(cSaId, redisList);
        }
        return redisList;
    }

    /**
     * Redis 조회
     */
    private List<PurchasingDto> getFromRedisNxvod211TobeSql01901(String cSaId) {
        ObjectMapper objectMapper = new ObjectMapper();
        return redisTemplate
                .opsForList()
                .range(KEY_PREFIX_SQL019_01 + cSaId, 0, -1)
                .stream()
                .map(str -> {
                    try {
                        return objectMapper.readValue(str, PurchasingDto.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toList());

    }

    /**
     * Flux DTO Redis 적재
     */
    private void setToRedisNxvod211TobeSql01901(String cSaId, List<PurchasingDto> dtoFlux) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            redisTemplate.opsForList().rightPushAll(KEY_PREFIX_SQL019_01 + cSaId, objectMapper.writeValueAsString(dtoFlux));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
