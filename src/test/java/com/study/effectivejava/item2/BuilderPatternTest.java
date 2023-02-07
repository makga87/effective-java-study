package com.study.effectivejava.item2;

import com.study.effectivejava.common.model.ProductDetail;
import org.junit.jupiter.api.Test;

class BuilderPatternTest {

    @Test
    void builderTest(){
       ProductDetail productDetail = ProductDetail.builder()
                .productId(1)
                .productName("괴도루팡")
                .build();

       System.out.println(productDetail);
    }
}