import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 덱을 구현한다.
    2) N을 입력받고, N for문 돌린다.
    3) 한줄씩 입력받아서 명령을 수행한다.

2. 제약 조건
    1 <= N <= 1,000,000
    시간 제한 0.5초

3. 의사결정
    1) N을 입력받는다. 덱을 하나 만든다.
    2) N만큼 for문을 돌린다.
    3) 한줄씩 받아서 명령 처리한다. switch가 나을지 메서드 따로하는게 나을지...
        => switch문과 메서드 따로하는 방식 간의 시간 차이는 크지 않다고 한다. switch 사용하기.

4. 문제 해결
    1) sout을 여러번 호출하는 경우, 매번 flush가 실행되 출력 성능이 저하된다.
    => sout 대신 Stringbuilder를 사용해 값을 누적시켰다가 마지막에 한번만 출력한다.
       대신 출력 형식을 유지하기 위해 append(\n) 해줘야 한다.
    2) removeLast()는 덱의 맨 뒤의 값을 지우고 "반환"도 하는 메서드이다!
       pop() : 덱에서는 "맨 처음 인덱스"의 요소를 제거하고,
               스택에서는 후입선출 중 "맨 마지막에 추가된" 요소를 제거한다. 맨 뒤의 요소를 제거하는게 아니다!
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>(); // 정수 데크
        int N = Integer.parseInt(br.readLine()); // N 받기

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // st 매번 초기화 필요
            String command = st.nextToken(); // 명령 받기
            // 명령 수행
            switch (command) {
                case "push_front": // 정수 받아서 맨 앞에 추가
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back": // 정수 받아서 맨 뒤에 추가
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front": // 맨 처음 값을 삭제하고 sb에 추가 + 줄바꿈
                    sb.append(deque.isEmpty() ? "-1" : deque.removeFirst()).append("\n");
                    break;
                case "pop_back": // 맨 마지막 값을 삭제하고 sb에 추가 + 줄바꿈
                    sb.append(deque.isEmpty() ? "-1" : deque.removeLast()).append("\n");
                    break;
                case "size": // 덱에 들어있는 정수 개수 추가 + 줄바꿈
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty": // 덱이 비어있으면 1, 비어있지 않으면 0 출력 + 줄바꿈
                    sb.append(deque.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front": // 덱이 비어있으면 -1, 그렇지 않으면 맨 앞 요소 삭제하지 않고 출력만 + 줄바꿈
                    sb.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
                    break;
                case "back": // 덱이 비어있으면 -1, 그렇지 않으면 맨 뒤 요소 삭제하지 않고 출력만 + 줄바꿈
                    sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

}