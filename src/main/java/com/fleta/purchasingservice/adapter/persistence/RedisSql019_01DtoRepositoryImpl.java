package com.fleta.purchasingservice.adapter.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleta.purchasingservice.domain.model.Sql019_01DtoProjection;
import com.fleta.purchasingservice.port.RedisDtoRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RedisSql019_01DtoRepositoryImpl implements RedisDtoRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final String KEY_PREFIX = "Sql019_01:";

    public RedisSql019_01DtoRepositoryImpl(
            RedisTemplate<String, String> redisTemplate
    ) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 전체 목록 Set (List Type)
     */
    public void setList(Map<String, List<String>> map) {
        map.entrySet().forEach(entry -> {
            redisTemplate
                    .opsForList()
                    .rightPushAll(KEY_PREFIX + entry.getKey(), entry.getValue());
        });
    }

    /**
     * SaId로 그룹화
     */
    public Map<String, List<String>> groupBySaId(List<Sql019_01DtoProjection> dtoFlux) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<String>> map = new HashMap<>();
        dtoFlux.stream().forEach(item -> {
            String saId = item.getSaId();
            if (!map.containsKey(saId)) {
                map.put(saId, new ArrayList<>());
            }
            List<String> getList = map.get(saId);
            try {
                getList.add(objectMapper.writeValueAsString(item));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return map;
    }
}
