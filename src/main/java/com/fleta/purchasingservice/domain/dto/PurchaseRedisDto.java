package com.fleta.purchasingservice.domain.dto;

import lombok.*;

/**
 * nxvod211_TOBE_SQL019_01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PurchaseRedisDto {
    private String saId;
    private String productId;
    private String expiredDate;
}
