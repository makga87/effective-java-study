# Serializable을 구현할지는 신중히 결정하라
- 직렬화 구현시 문제점
  1. 릴리즈 한 뒤 수정하기 어렵다.
  2. 버그와 보안구멍이 생길 확률이 높다.
  3. 신버전 릴리즈시 테스트할 것이 늘어난다.
- 작성하는 클래스의 인스턴스 필드가 직렬화와 확장이 모두 가능하다면
  - finalize 메서드를 재정의하지 못하게 해야한다.
  - finalize 메서드를 자신이 재정의하면서 final로 선언하면 된다.
- Serializable을 구현하지 않기로 하면, 매개변수가 없는 생성자를 제공하라
- 내부 클래스는 직렬화를 구현하지 말아야 한다.