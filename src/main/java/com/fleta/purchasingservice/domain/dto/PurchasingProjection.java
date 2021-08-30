package com.fleta.purchasingservice.domain.dto;

import org.springframework.beans.factory.annotation.Value;

public interface PurchasingProjection {
      @Value("#{target.product_id}")
      String getProductId();
      @Value("#{target.expired_date}")
      String getExpiredDate();
}