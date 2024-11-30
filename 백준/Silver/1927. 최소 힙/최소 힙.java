import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) N개의 연산을 수행한다.
    2) 입력값이 자연수라면 배열에 추가하고, 입력값이 0이라면 배열에서 최솟값을 출력하고 제거한다.

2. 제약 조건
   0 <= X <= 2^31
   시간 제한 2초

3. 의사결정
    1) 첫째줄에서 N을 받는다. 최솟값을 뽑아야 하니까 최소힙을 사용한다.
    2) N만큼 for문 돌린다.
      (1) 받은 입력값이 0일경우
         - 힙이 비어있다면 0 출력
         - 비어있지 않다면 최솟값 출력 및 삭제
      (2) 받은 입력값이 자연수일 경우
         - 힙에 넣기

4. 문제 해결
    1) 우선순위 큐에서 add()는 요소를 추가할 수 없는 경우 예외 발생, offer()는 false 리턴.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // N 받기
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 최소힙 선언

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine()); // 자연수 받기

            if (x == 0) {
                System.out.println(heap.isEmpty() ? 0 : heap.poll());
            } else {
                heap.offer(x);
            }
        }
    }
}