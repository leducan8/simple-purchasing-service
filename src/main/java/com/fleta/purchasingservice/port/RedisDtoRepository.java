package com.fleta.purchasingservice.port;

import com.fleta.purchasingservice.domain.model.Sql019_01DtoProjection;

import java.util.List;
import java.util.Map;

public interface RedisDtoRepository {
    void setList(Map<String, List<String>> map);

    Map<String, List<String>> groupBySaId(List<Sql019_01DtoProjection> sql019_01DtoProjectionList);
}
