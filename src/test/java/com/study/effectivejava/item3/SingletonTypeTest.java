package com.study.effectivejava.item3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.effectivejava.common.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

class SingletonTypeTest {

    @DisplayName("강제 생성해보기")
    @Test
    void reflectionAccess() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<ProductService> constructor =  ProductService.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        ProductService productService = constructor.newInstance();

        Assertions.assertNotEquals(productService, ProductService.INSTANCE);
    }

    @DisplayName("1. 마음이 바뀌면 싱글턴이 아니게 변경가능")
    @Test
    void advantage1(){
        /*
         */
    }

    @DisplayName("2. 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다")
    @Test
    void advantage2(){
        /*
        장점이 뭐고, 코드 예제는?
         */
    }

    @DisplayName("3. 정적 팩터리의 메서드 참조를 Supplier로 사용가능")
    @Test
    void advantage3(){
        System.out.println("STEP 1");
        Supplier<ProductService> supplier = ProductService::getInstance;
        System.out.println("STEP 2");
        supplier.get();
        System.out.println("STEP 3");

        /*
        Supplier를 쓰면 지연 로딩이 되는 것이 장점인 것 같다
         */
    }

    @DisplayName("직렬화 역직렬화 테스트 - ObjectMapper")
    @Test
    void note1() throws IOException {

        /*
        readResolve 추가전
         */
        ProductService productService = ProductService.INSTANCE;
        System.out.println(productService);

        ObjectMapper mapper = new ObjectMapper();
        byte[] productServiceAsBytes = mapper.writeValueAsBytes(productService);
        System.out.println("Write value");

        ProductService _productService = mapper.readValue(productServiceAsBytes, ProductService.class);
        System.out.println("Read value");
        System.out.println(_productService);

        /*
        readResolve 추가전
         */
//        Assertions.assertNotEquals(productService, _productService);
        Assertions.assertNotEquals(productService, _productService);
    }

    @DisplayName("직렬화 역직렬화 테스트 - Stream")
    @Test
    void note2() throws IOException {

        ProductService productService = ProductService.INSTANCE;
        System.out.println(productService);

        byte[] productServiceAsBytes = serialize(productService);
        System.out.println("Write value");

        ProductService _productService = (ProductService) deserialize(productServiceAsBytes);
        System.out.println("Read value");
        System.out.println(_productService);

        /*
        readResolve 추가전
         */
//        Assertions.assertNotEquals(productService, _productService);
        Assertions.assertEquals(productService, _productService);
    }

    private byte[] serialize(Object instance) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (bos; ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(instance);
        } catch (Exception e) {
            // ... 구현 생략
        }
        return bos.toByteArray();
    }

    private Object deserialize(byte[] serializedData) {
        ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
        try (bis; ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        } catch (Exception e) {
        }
        return null;
    }

}