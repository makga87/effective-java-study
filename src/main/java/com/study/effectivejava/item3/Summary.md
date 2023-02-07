# 싱글턴 타입 보증

## 요약
1. public static final 방식
   1. AccessibleObject.setAccesible 등으로 private 생성자가 호출 가능
      1. 생성자의 두 번째 객체 생성 시, 예외를 던지는 방식으로 방어
2. 정적팩터리 메서드 방식
   1. API를 바꾸지 않고도, 싱글턴이 아니게 변경가능
   2. 제네릭 싱글턴 팩터리로 만들 수 있다
      1. 어떤 장점인지 잘 모르겠다
   3. 정적팩터리 메서드 참조를 Supplier로 사용할 수 있다
      1. ex) Supplier<Elvis> 
3. 싱글턴 클래스는 역직렬화 시, 새로운 인스턴스가 생성되므로, readResolve 메서드를 추가하라