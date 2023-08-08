# 공유 중인 가변 데이터는 동기화해 사용하라
- 일반적으로 스레드는 CPU cache로부터 데이터를 읽는다.
- volatile 사용 시, 자바 변수들을 Main Memory에 저장하고, CPU cache가 아닌 Main Memory에서 read/write를 한다.
- volatile을 사용한다고 무조건 해결이 되진 않는다. write / read 시간의 틈을 비집고 읽는다면, 잘못된 값을 읽을 수 있고 원자성(atomic)이 보장되지 않는다.

### [NOTE]
1. volatile은 메인메모리에서 진행하므로, CPU cache보다 비용이 더 크다. 즉, 성능에도 영향을 줄 수 있다고 한다.
2. 대체안으로 Atomic~~ 객체들이 있다. Lock free하고, volatile은 동기화의 두 효과 중, 통신쪽만 지원하지만, 이 패키지는 원자성까지도 지원한다.
   1. 심지어 성능도 더  우수하다


### [REFERENCE]
> https://nesoy.github.io/articles/2018-06/Java-volatile

### [Question]
1. 예외는 직렬화할 수 있다는 사실을 기억하자. (직렬화에는 많은 부담이 따르니) 이 사실만으로도 나만의 예외를 새로 만들지 않아야할 근거로 충분할 수 있다.
   - 직렬화 / 역직렬화 시, CPU / 메모리 부담이 크므로, 굳이 필요없는 상황에서는 제외 시킨다