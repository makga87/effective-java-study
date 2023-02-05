# 정적팩터리메서드 요약

## 장점
1. 이름을 가질 수 있다
2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다
   1. 미리 static 파라메터로 생성해두는 방식
      1. Boolean.valueOf(boolean)
   2. Flyweight pattern
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다
4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다
5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다
   1. Ex) JDBC
      1. Connection : 서비스 인터페이스
      2. DriverManger.registerDriver : 제공자 등록 API 역할
      3. DriverManger.getConnection : 서비스 접근 Api
      4. Driver : 서비스 제공자 인터페이스
   2. DriverManger내부 소스확인 시, 이제 Class.forName은 사용 안해도 됨

## 단점
1. 상속하려면 public 이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다
2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다

