# 이왕이면 제네릭 메서드로 만들라
- 때때로 불변객체를 여러타입으로 만들어야 할 때가 있다.
  - 제네릭은 런타임에 타입 정보가 소거되므로 하나의 객체를 어떤 타입으로든 매개변수화 할 수 있다.
  - 하지만 이렇게 하려면 요청한 타입 매개변수에 맞게 매번 그 객체의 타입을 바꿔주는 정적 팩터리를 만들어야 한다. 이 패턴을 제네릭 싱글턴 팩터리라 한다.
    - ex) Collections.reverseOrder, Collections.isEmpty

### 재귀적 타입한정
- 자기 자신이 들어간 표현식을 사용하여 타입 매개변수의 허용범위를 한정
  - ex) 자신과 같은 타입의 객체만을 비교 
  - `public interface Comparable<T extends Comparable<T>> {
    int compareTo(T o);
    }`

