# equals는 일반 규약을 지켜 재정의하라

## 재정의에는 함정이 도사리고 있다. 다음 열거 상황 중 1개라도 해당되면 재정의 하지 말 것
1. 각 인스턴스가 본질적으로 고유하다
   1. ex) Thread
2. 인스턴스의 '논리적 동치성'을 검사할일이 없다. 
   1. ex) Pattern.equals
3. 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어 맞는다.
   1. ex) AbstractSet/Set, AbstractList/List, AbstractMap/Map
4. 클래스가 private이거나 package-private이고 equlas 메서드를 호출할 일이 없다.

## equlas 재정의  시점
- 객체 식별성(물리적으로 같은가?)가 아니라 논리적 동치성을 확인해야하는데, 상위 클래스의 equals가 논리적 동치성을 비교하도록 재정의되지 않은 경우
- 같은 인스턴스가 둘 이상 만들어지지 않음을 보장할 때. ex) Enum


## equals의 일반 규약 (재정의시 필수로 따라야 함)
1. 반사성 : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true
2. 대칭성 : null이 아닌 모든 참조 값 x, y에 대해, x.equals(y)이면, y.equals(x)이다.
3. 추이성 : null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y), y.equals(z)이면, x.equals(z)이다.
   - 구체 클래스를 확장해 값을 추가한 클래스 예 : java.sql.Timestamp는 java.util.Date를 확장한 후 nanoseconds필드를 추가했다.
     - 그 결과 Timestamp의 equals는 대칭성을 위배하며, Date객체와 한 컬렉션에 넣거나 서로 섞어 사용하면 엉뚱하게 동작할 수 있다.
4. 일관성 : null이 아닌 모든 참조 값 x, y에 대해 x.equals(y)를 반복해서 호출하면 항상 true, 혹은 false이다.
5. null-아님 : null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.
   - 명시적 null 검사보단 묵시적 null 검사를 사용하라
     - ex) `if(!(o instanceof MyType))`

## 양질의 equals 메서드 구현방법
1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인
   1. 단순히 성능 최적화용, 비교작업이 복잡한 경우 값어치 함
2. instanceof 연산자로 입력이 올바른 타입인지 확인
   1. 자신을 구현한 클래스끼리도 비교할 수 있도록 equals규약을 수정하기도 한다. 이런 인터페이스를 구현한 클래스라면 equals에서 (클래스가 아닌) 해당 인터페이스를 사용해야한다.
      1. ex) Set, List, Map, etc...
3. 입력을 올바른 타입으로 형변환 한다.
4. 입력 객체와 자기 자신의 대응되는 핵심 필드들이 모두 일치하는지 하나씩 검사한다.

## NOTE
- 때론, null도 정상 값으로 취급하는 참조 타입 필드도 있다. 이런 필드는 정적 메서드인 Object.equals로 비교해 NullPointerException 발생을 예방하자
- equals를 다 구현했다면 세가지만 자문해보자. 대칭적인가? 추이성이 잇는가? 일관적인가?
- equals를 재정의할 땐, hashcode도 반드시 재정의 하자
- 너무 복잡하게 해결하려 들지 말자.
  - 별칭은 비교하지 말것. ex) File클래스라면 심볼릭 링크를 비교해 같은 파일을 가리키는지를 확인하려 들면 안된다.
- Object 외의 타입을 매개변수로 받는 equals메서드는 선언하지 말자.
  - ex) 잘못된 예 `public boolean equals(MyClass o) {...}`
  - 위 예제는 재정의가 아닌, 다중정의이다.
  - 타입을 구체적으로 명시하면 오히려 해가 된다.
- equals를 작성하고 테스트하는 일은 지루하고 테스트하는 코드도 항상 뻔하다.
  - 구글이 만든 AutoValue가 이를 대신해준다.


