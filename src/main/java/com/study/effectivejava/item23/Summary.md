# 태그 달린 클래스보다는 클래스 계층구조를 활용하라

### 태그란?
- 해당 클래스가 어떤 타입인지에 대한 정보를 담고 있는 멤버 변수
  - ex) Figure 클래스의 Shape 멤버 변수
- 태그 달린 클래스는 장황하고, 오류를 내기 쉽고 비효율적이다.
- 자바와 같은 객체 지향 언어는 타입 하나로 다양한 의미의 객체를 표현하는 수단을 제공한다. 바로 클래스 계층구조를 활용하는 서브타이핑을 제공한다.
- 태그 달린 클래스는 클래스 계층 구조를 어설프게 흉내낸 아류일 뿐이다.

### 태그달린 클래스를 계층구조로 바꾸는 방법
- 루트 객체에 각자 고유의 동작을 하는 메서드는 추상 메서드로 변경한다.
- 공통으로 사용하는 부분은 일반메서드로 구현한다.