package com.fleta.purchasingservice.domain.dto;

import org.springframework.beans.factory.annotation.Value;

public interface PurchaseRedisDtoProjection {
      @Value("#{target.sa_id}")
      String getSaId();
      @Value("#{target.product_id}")
      String getProductId();
      @Value("#{target.expired_date}")
      String getExpiredDate();
}