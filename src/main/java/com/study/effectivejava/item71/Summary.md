# 필요 없는 검사 예외 사용은 피하라

## 1. 검사 예외가 단 하나뿐이라면 오직 그 예외 때문에 API 사용자는 try 블록을 추가해야하고 스트림에서 직접 사용하지 못하게 된다. 그러니 이런 상황이라면 검사 예외를 안던지는 방법이 없는지 고민해라
- 검사 예외를 회피하는 방법
  1. 적절한 결과 타입을 담은 옵셔널을 반환
     - 검사 예외를 던지는 대신 단순히 빈 옵셔널을 반환한다.
       - 이럴 경우, 예외가 발생한 이유를 알려주는 부가 정보를 담을 수 없다
  2. 검사 예외를 던지는 메서드를 2개로 쪼개서 비검사 예외로 변경
     - 이 방식이 딱히 더 아름답진 않다...

## 2. API 호출자가 예외 상황에서 복구할 방법이 없다면 비검사 예외를 던지자
