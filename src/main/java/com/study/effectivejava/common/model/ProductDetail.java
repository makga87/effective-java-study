package com.study.effectivejava.common.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ProductDetail {

    private int productId;
    private String productName;
    private String productPlace;
    private LocalDate productStartDate;
    private LocalDate productEndDate;
    private String etc;

    @Builder
    private ProductDetail(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

}
