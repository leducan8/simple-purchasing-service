package com.fleta.purchasingservice.port.repository;

import com.fleta.purchasingservice.domain.model.PtVoBuy;
import com.fleta.purchasingservice.domain.dto.PurchaseRedisDtoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetPurchaseForRedisRepository<T> extends CrudRepository<PtVoBuy, Long> {

    @Query(value = " SELECT " +
            "     A.sa_id," +
            "     A.product_id," +
            "     A.expired_date" +
            " FROM VODUSER.PT_VO_BUY A " +
            " WHERE 1=1 " +
            " AND COALESCE((REGEXP_SPLIT_TO_ARRAY(replace(replace(A.ERROR_MSG, '||', '|Z|'), '|', '^'), '\\\\^'))[4], 'N') != 'X' LIMIT 100000", nativeQuery = true)
    List<PurchaseRedisDtoProjection> nxvod211TobeSql01901();

}
