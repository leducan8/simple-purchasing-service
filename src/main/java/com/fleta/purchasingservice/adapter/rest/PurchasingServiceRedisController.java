package com.fleta.purchasingservice.adapter.rest;

import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.domain.dto.PurchaseRedisDtoProjection;
import com.fleta.purchasingservice.port.repository.CommonRepository;
import com.fleta.purchasingservice.port.service.RedisSqlDtoService;
import com.fleta.purchasingservice.port.service.SetPurchaseForRedisService;
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
public class PurchasingServiceRedisController extends RedisDtoController {

    private CommonRepository commonRepository;
    private SetPurchaseForRedisService setPurchaseForRedisService;
    private RedisSqlDtoService redisSqlDtoService;

    @Autowired
    public PurchasingServiceRedisController(
            CommonRepository commonRepository,
            RedisSqlDtoService redisSqlDtoService,
            SetPurchaseForRedisService setPurchaseForRedisService
    ) {
        this.commonRepository = commonRepository;
        this.redisSqlDtoService = redisSqlDtoService;
        this.setPurchaseForRedisService = setPurchaseForRedisService;
    }

    /**
     * 전체 목록 Set
     */
    @PostMapping("/list")
    public ResponseEntity setList() {
        List<PurchaseRedisDtoProjection> redisList = setPurchaseForRedisService.getSQL019_01List();
        Map<String, List<String>> map = redisSqlDtoService.groupBySaId(redisList);
        redisSqlDtoService.setList(map);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    /**
     * 조건 조회
     */
    @GetMapping("/{saId}")
    public ResponseEntity<List<PurchasingDto>> getListBySaId(@PathVariable String saId) {
        return new ResponseEntity<>(commonRepository.nxvod211TobeSql01901(saId), HttpStatus.OK);
    }

}
