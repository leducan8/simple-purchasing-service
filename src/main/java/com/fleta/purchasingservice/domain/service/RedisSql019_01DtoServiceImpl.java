package com.fleta.purchasingservice.domain.service;

import com.fleta.purchasingservice.domain.model.Sql019_01DtoProjection;
//import com.fleta.purchasingservice.port.RedisDtoRepository;
import com.fleta.purchasingservice.port.RedisDtoRepository;
import com.fleta.purchasingservice.port.RedisSql019_01DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RedisSql019_01DtoServiceImpl implements RedisSql019_01DtoService {

    @Autowired
    private RedisDtoRepository redisDtoRepository;


    @Override
    public void setList(Map<String, List<String>> map) {
        redisDtoRepository.setList(map);
    }

    @Override
    public Map<String, List<String>> groupBySaId(List<Sql019_01DtoProjection> sql019_01DtoProjectionList) {
        return redisDtoRepository.groupBySaId(sql019_01DtoProjectionList);
    }
}
