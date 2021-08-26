package com.fleta.purchasingservice.adapter.rest;

import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.domain.model.PurchasingProjection;
import com.fleta.purchasingservice.domain.model.Sql019_01DtoProjection;
import com.fleta.purchasingservice.port.CommonRepository;
import com.fleta.purchasingservice.port.RedisSql019_01DtoService;
import com.fleta.purchasingservice.port.SetPurchaseForRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Redis Controller - for SQL019_01 DTO
 */
@RestController
@RequestMapping("/redis/sql019-01")
public class RedisSql019_01DtoController extends RedisDtoController {

    private CommonRepository commonRepository;
    private SetPurchaseForRedisService setPurchaseForRedisService;
    private RedisSql019_01DtoService redisSql019_01DtoService;

    @Autowired
    public RedisSql019_01DtoController(
            CommonRepository commonRepository,
            RedisSql019_01DtoService redisSql019_01DtoService,
            SetPurchaseForRedisService setPurchaseForRedisService
    ) {
        this.commonRepository = commonRepository;
        this.redisSql019_01DtoService = redisSql019_01DtoService;
        this.setPurchaseForRedisService = setPurchaseForRedisService;
    }

    /**
     * 전체 목록 Set
     */
    @PostMapping("/list")
    public ResponseEntity setList() {
        List<Sql019_01DtoProjection> redisList = setPurchaseForRedisService.getSQL019_01List();
        Map<String, List<String>> map = redisSql019_01DtoService.groupBySaId(redisList);
        redisSql019_01DtoService.setList(map);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    /**
     * 조건 조회
     */
    @GetMapping("/{saId}")
    public ResponseEntity<List<PurchasingProjection>> getListBySaId(@PathVariable String saId) {
        return new ResponseEntity<>(commonRepository.nxvod211TobeSql01901(saId), HttpStatus.OK);
    }

}
