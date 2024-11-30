import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) N을 입력받은 뒤, N개의 줄을 입력받는다.
    2) 각 줄의 처음에는 정수 a가 있다.
    3) 0일 경우 최댓값을 출력 및 삭제하고, a가 0이 아닐경우 그 다음에 들어오는 a개의 숫자를 입력받아 저장한다.

2. 제약 조건
   1 <= N <= 5000
   1 <= a <= 100

3. 의사결정
    1) 첫째줄에서 N을 받고, 최대 힙을 선언한다. 한줄에 여러 숫자가 들어올 수 있으므로 StringTokenizer를 사용한다.
    2) N만큼 for문을 돌리고, 입력값을 받는다.
      (1) 입력값이 0일 경우
        - 힙이 비어있다면 -1 출력
        - 비어있지 않다면 최댓값 출력 및 삭제
      (2) 입력값이 0이 아닌 a일 경우
        - a개의 숫자를 받아서 힙에 저장한다.

4. 문제 해결
    1)

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 받기

        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a); // 최대 힙 선언

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // a 받기

            if (a == 0) { // a = 0일 경우, 아이들에게 선물을 준다.
                System.out.println(maxheap.isEmpty() ? -1 : maxheap.poll());
            } else { // a != 0 일 경우, a개의 선물을 저장한다.
                for (int j = 0; j < a; j++) {
                    int present = Integer.parseInt(st.nextToken());
                    maxheap.add(present);
                }
            }
        }
    }
}