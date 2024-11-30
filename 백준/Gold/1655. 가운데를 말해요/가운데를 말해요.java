import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 백준이가 N개의 정수 x를 외친다. 하나씩 외칠때마다 동생이 말해야 하는 수를 출력한다.
    2) 지금까지 백준이가 말한 정수가 총 짝수 개라면 중간의 두 수 중 작은것을 출력
    3) 짝수개가 아니라면 '중간값' 출력

2. 제약 조건
   1 <= N <= 100,000
   -10,000 <= x <= 10,000

3. 의사결정
    1) N을 입력받는다. 최소힙, 최대힙을 하나씩 만든다.
    2) for문을 N번 돌린다.
      (1) x를 입력받아서 최소 힙, 최대 힙, 리스트에 각각 넣는다.

      x를 입력받는다

      i = 0인 경우 최소힙에 저장하고 바로 출력 (처음)

      i = 1 이상인 경우
        - 최대힙이 비어있거나, x <= 최대 힙인 경우 최대힙에 우선 넣는다. // 최대힙의 루트값 출력
        - 최소힙이 비어있거나, x > 최소 힙인 경우 최소힙에 넣는다. // 최대힙의 루트값 출력

      * 공통 : 최대힙, 최소힙 간 사이즈가 2 이상 차이날 경우, 많은 쪽에서 적은 쪽으로 1개 옮긴다.


4. 문제 해결
    1) 0.1초 시간제한인데 여러번 sort를 할 수는 없다... => 중간값!! 만 중요하기 때문에,
    최대 힙에다가 중간값 중 작은 값을, 최소 힙에다가 중간 값 중 큰 값을 넣는 것이다.
    [ X, X, X, ... 2, 6, ...,  X, X, X ]
    => X ~ 2까지 중에서 최대는 5  /   6 ~ X까지 중에서 최소는 6
    2) i가 짝수일때, 홀수일때를 나눠서 처리할 필요 없다. 어차피 항상 중간값 출력하니까.
    3) 조건문에 너무 많은 조건을 추가하지 말자. 반례 찾기도 어렵고 이해하기도 힘들다...

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // 최대힙
        int N = Integer.parseInt(br.readLine()); // 백준이가 외치는 정수의 개수

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            // 첫 수는 최대힙에 넣고, 바로 출력한다.
            if (maxHeap.isEmpty()) {
                maxHeap.add(x);
                sb.append(x).append("\n");
                continue; // 다음 for문 반복
            }

            // 최대 힙이 비어있거나, 최대힙보다 x가 작은 경우 최대힙에 넣는다.
            if (maxHeap.peek() >= x) {
                maxHeap.add(x);
            } else { // 그렇지 않은 경우 최소힙에 넣는다.
                minHeap.add(x);
            }

            // 두 우선순위 큐의 길이가 2 이상 차이날 경우 조절 : 최대힙과 최소힙은 같은 크기거나, 최대힙이 1개 더 많아야 한다.
            if (maxHeap.size() - minHeap.size() > 1) { // 최대힙이 2개 이상 더 많은 경우
                minHeap.add(maxHeap.poll()); // max -> min으로 이동
            } else if (minHeap.size() > maxHeap.size()) { // 최소힙이 더 많을 경우
                maxHeap.add(minHeap.poll()); // min -> max로 이동
            }

            // 중간값 중 작은 값, 또는 중간값을 출력하려면 항상 최대힙의 루트를 뽑으면 된다.
            sb.append(maxHeap.peek()).append("\n");

        }

        System.out.println(sb);
    }
}