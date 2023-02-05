package com.study.effectivejava.item1;

import com.study.effectivejava.common.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StaticFactoryMethodTest {

    @DisplayName("1. 이름을 가질 수 있다")
    @Test
    void advantage1(){
        Reserve.statusOf(ReserveStatus.COMPLETE);
    }

    @DisplayName("2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다")
    @Test
    void advantage2() {
      Reserve reserve1 = Reserve.statusOf(ReserveStatus.COMPLETE);
      Reserve reserve2 = Reserve.statusOf(ReserveStatus.COMPLETE);

      assertEquals(reserve1, reserve2);

      Reserve _reserve1 = Reserve.getInstance(ReserveStatus.COMPLETE);
      Reserve _reserve2 = Reserve.getInstance(ReserveStatus.COMPLETE);

      assertNotEquals(_reserve1, _reserve2);
    }

    @DisplayName("3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다")
    @Test
    void advantage3(){
        /*
        Collections 참고
        Collection 의 구현체들을 가져올 수 있음 (Map, Queue, List, Set 등등)
         */

        Order offlineOrder = Order.getOfflineOrder(Product.valueOf(5000));
        Order onlineOrder = Order.getOnlineOrder(Product.valueOf(5000));

        System.out.println(offlineOrder.getPayment());
        System.out.println(onlineOrder.getPayment());
    }

    @DisplayName("4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다")
    @Test
    void advantage4(){

        /*
        EnumSet.noneOf 참고
        매개변수 Enum 사이즈에 따라, 다른 객체 생성
         */
        Order offlineOrder = Order.of(Product.valueOf(10000), OrderType.OFFLINE);
        Order onlineOrder = Order.of(Product.valueOf(10000), OrderType.ONLINE);

        System.out.println(offlineOrder.getPayment());
        System.out.println(onlineOrder.getPayment());
    }

    @DisplayName("5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다")
    @Test
    void advantage5(){

        /*
        해당 내용은 여러 예제를 본 결과, 코드 작성 시점이 아닌, 서비스 기동 시점에 반환할 객체가 정해진다고 보여짐
        Class.forName({package});
        Connection connection = DriverManager.getConnection({url}, {user}, {password});

        JDBC가 자바 6 전에 등장한 개념이라 ServiceLoader를 사용하지 않는다고 하나
        현재 버전의 DriverManger 소스코드를 보면, ServiceLoader로 대체되어 있다

        그러므로 8버전에선 Class.forName은 이제 사용하지 않아도 됨
        */
    }

    @DisplayName("1. 상속하려면 public 이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다")
    @Test
    void disadvantage1(){

        /*
        해당 내용이 그 동안 해왔던 방식과는 많이 차이가 나지만, 자바 개발자들 사이에는
        불변 객체가 가장 좋은 객체로 인식되는 듯 하다

        상속을 사용하였을 때 생기는 캡슐화의 위반이나 유연성 감소가 발생한다고 컴포지션 방식으로 개발하는 걸 추천한다고 함
        (상속 사용 시, 부모 객체에 변화가 일어나면 자식 객체들도 고스란히 영향을 받게 된다)
        (컴포지션은 기존 클래스의 확장 대신, 새 클래스에 기존 클래스를 private 필드로 참조하는 것,
        이는 기존 클래스의 내부 구현 방식이나 새로운 메서드 추가에 자유로워진다)
        상속은 순수히 is-a 관계일 때 사용할 것을 추천
       */
    }

    @DisplayName("2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다")
    @Test
    void disadvantage2(){
        /*
       컨벤션을 만들거나, 흔히 사용하는 규약을 만드는 것으로 대체
       */
    }

}