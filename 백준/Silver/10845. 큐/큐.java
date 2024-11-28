import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) N개의 명령이 주어진다.
    2) push 명령의 경우 정수가 함께 입력된다.
    3) 각 명령을 수행하면서, "출력해야 하는 명령"이 주어질 때 한 줄에 하나씩 출력한다.

2. 제약 조건
    1 <= N <= 10000
    1 <= 주어지는 정수 <= 100000

3. 의사결정
    1) N을 입력받는다.
    2) 정수 데크를 구현한다. 문장을 입력받으면 공백으로 구분하여 배열에 저장한다.
    3) switch문으로 각 명령 수행을 작성한다.
        (1) push의 경우 배열[1]에 들어간 정수를 함께 처리한다.
        (2) push를 제외한 나머지 연산은 모두 출력이 필요하다. 한 줄에 하나씩 출력해야 하므로 \n을 누적한다.

4. 문제 해결
    1) queue.poll()  : 큐의 첫번째 요소를 삭제 및 반환 + 큐가 비어있다면 예외 발생
       queue.remove(): 큐의 첫번째 요소를 삭제 및 반환 + 큐가 비어있다면 null 반환
    2) case "back"에서 마지막 요소를 출력하기 위해, case "push"에서 마지막 요소를 미리 저장해놓는 방식으로 변경헸다.
        => 이후 ArrayDeque로 변경하면서 peekLast() 메서드로 더 간편히 변경했다.
    3) ArrayDeque는 LinkedList보다 메모리 사용량이 적고 성능이 빠름.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        Deque<Integer> deque = new ArrayDeque<>(); // 데크 생성

        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 문장 받기
            String[] command = line.split(" "); // 명령어 + 숫자(push일 경우) 조합의 배열 생성

            switch (command[0]) {
                case "push":
                    deque.addLast(Integer.parseInt(command[1])); // 입력받은 숫자를 deque에 추가
                    break;
                case "pop":
                    // 큐가 비어있을 경우 -1을 출력, 비어있지 않을 경우 앞 요소 빼서 출력
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                    sb.append("\n");
                    break;
                case "size":
                    // 큐에 들어있는 정수 개수 출력
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "empty":
                    // 큐가 비어있으면 1, 아니면 0 출력
                    sb.append(deque.isEmpty() ? 1 : 0);
                    sb.append("\n");
                    break;
                case "front":
                    // 큐의 가장 앞에 있는 정수를 출력한다.
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
                    sb.append("\n");
                    break;
                case "back":
                    // 큐의 가장 뒤에 있는 정수를 출력한다.
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb); // 출력 한번에

    }
}