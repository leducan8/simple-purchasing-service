package com.fleta.purchasingservice.domain.model;

import org.springframework.beans.factory.annotation.Value;

public interface Sql019_01DtoProjection {
      @Value("#{target.sa_id}")
      String getSaId();
      @Value("#{target.product_id}")
      String getProductId();
      @Value("#{target.expired_date}")
      String getExpiredDate();
}