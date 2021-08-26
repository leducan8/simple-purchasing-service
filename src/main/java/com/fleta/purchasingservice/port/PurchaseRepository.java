package com.fleta.purchasingservice.port;

import com.fleta.purchasingservice.domain.model.PurchasingProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fleta.purchasingservice.domain.model.PtVoBuy;

import java.util.List;

@Repository
public interface PurchaseRepository<T> extends CrudRepository<PtVoBuy, Long> {

    @Query(value = " SELECT A.product_id," +
            "       A.expired_date" +
            " FROM VODUSER.PT_VO_BUY A " +
            " WHERE 1=1 " +
            " AND A.sa_id = :saId" +
            " AND COALESCE((REGEXP_SPLIT_TO_ARRAY(replace(replace(A.ERROR_MSG, '||', '|Z|'), '|', '^'), '\\\\^'))[4], 'N') != 'X'", nativeQuery = true)
    List<PurchasingProjection> nxvod211TobeSql01901(@Param("saId") final String cSaId);

}
