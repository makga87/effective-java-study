# finalizer와 cleaner 사용을 피하라

## 요약
1. finalizer는 예측 불가하고, 일반적으로 불필요, 우선순위 처리에 밀려 제 때 실행되어야 하는 작업은 절대 불가, 심지어 속도도 느림
   1. JAVA9에서는 depreacted
   2. 하지만 자바 라이브러리에서도 여전히 쓰임 (FileInputStream/FileOutputStream, ThreadPoolExecutor)
   3. finalizer 동작 중, 발생한 예외는 무시되며, 처리할 작업이 남았더라도 그 순간 종료
   4. 잡지 못한 예외 때문에 해당 객체는 자칫 마무리가 덜 된 상태로 남을 수 있음.
   5. 예외 발생 시 경고 조차 출력안함
   6. 성능상 문제도 있음 (50배 정도)
   7. 심각한 보안문제 있음 
      1. readObject, readResolve에서 예외 발생 시, 생성 되다만 객체에서 악의적인 하위 클래스의 finalizer가 수행될 수 있게 한다.
   8. 이 finalizer는 정적 필드에 자신의 참조를 할당하여 가비지 컬렉터가 수집하지 못하게 막을 수 있다.
   9. 객체 생성을 막으려면, 생성자에서 예외를 던지는 것만으로 충분하지만, finalizer가 있다면 그렇지도 않다.
   10. final이 아닌 클래스를 finalizer 공격으로부터 방어 하려면, 아무일도 하지 않는 finalize 메서드를 만들고 final로 선언하자.
2. cleaner도 finalizer보다 덜 위험할 뿐, 여전히 예측 불가, 느림
3. 위 두 기능은 GC 알고리즘의 구현마다 천차 만별
4. 상태를 영구적으로 수정하는 작업에서는 절대 의존해서는 안됨ㅍ
5. System.gc, System.runFinalization 메서드에 현혹되지 말 것. finalizer, cleaner가 실행될 가능성을 높여줄 뿐 보장해주진 않음.
   1. 보장해주겠다는 두 메서드가 있다. System.runFinalziersOnExit, Runtime.runFinalizersOnExit 하지만, 심각한 결함으로 욕먹음
6. 위 두 기능을 대신해줄 AutoCloseable을 사용하자
7. 두 api를 잘 쓰는 방법
   1. 안전망 역할을 하는 경우
   2. 네이티브 피어와 연결된 객체에서 사용

## Question
1. 실제 쓰이는 코드는 어떤 모습일까?
2. 보안문제를 일으켜보자
3. 기본생성자에 예외를 넣고, finalizer를 쓰면 무슨일이 벌어지나?
4. 위 내용이 쓰인것으로 의심되는 코드를 찾아보기
