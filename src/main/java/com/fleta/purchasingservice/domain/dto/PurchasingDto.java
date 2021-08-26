package com.fleta.purchasingservice.domain.dto;

import com.fleta.purchasingservice.grpc.common.PurchasingOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchasingDto {
    private String productId;
    private String expiredDate;

    public PurchasingDto(String productId, String expiredDate) {
        this.productId = productId;
        this.expiredDate = expiredDate;
    }

    public PurchasingOutput toPurchasingOutput() {
        return PurchasingOutput.newBuilder()
                .setProductId(this.productId)
                .setExpiredDate(this.expiredDate)
                .build();
    }
}
