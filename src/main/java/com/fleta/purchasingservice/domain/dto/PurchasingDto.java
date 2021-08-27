package com.fleta.purchasingservice.domain.dto;

import com.fleta.purchasingservice.grpc.common.PurchasingOutput;
import lombok.*;

@Getter @Setter
@Builder
@ToString
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

    public static PurchasingDto buildFromPurchasingOutput(PurchasingOutput purchasingOutput) {
        return new PurchasingDto(
                purchasingOutput.getProductId(),
                purchasingOutput.getExpiredDate());
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getProductId() {
        return productId;
    }

    public String getExpiredDate() {
        return expiredDate;
    }
}

