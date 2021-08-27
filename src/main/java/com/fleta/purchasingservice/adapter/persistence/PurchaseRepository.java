package com.fleta.purchasingservice.adapter.persistence;

import com.fleta.purchasingservice.domain.dto.PurchasingDto;
import com.fleta.purchasingservice.domain.model.PurchasingProjection;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PurchaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PurchasingDto> nxvod211TobeSql01901(String saId) {
        String sql = " SELECT A.product_id," +
                "       A.expired_date" +
                " FROM VODUSER.PT_VO_BUY A " +
                " WHERE 1=1 " +
                " AND A.sa_id = :saId" +
                " AND COALESCE((REGEXP_SPLIT_TO_ARRAY(replace(replace(A.ERROR_MSG, '||', '|Z|'), '|', '^'), '\\\\^'))[4], 'N') != 'X'";
        try {
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("saId", saId);
            JpaResultMapper resultMapper = new JpaResultMapper();
            List<PurchasingDto> searchResult = resultMapper.list(query, PurchasingDto.class);
            return searchResult;
        } catch (Exception ex) {
            throw ex;
        }

    }

}
