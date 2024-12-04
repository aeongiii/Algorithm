import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) N개의 요소 X1 ~ Xn까지 주어진다.
    2) 각 요소를 좌표압축(순위별로 다시 매김)한 뒤, 입력받은 순서대로 압축한 값을 출력한다.

2. 제약 조건
   1 <= N <= 1,000,000
   -10^9 <= Xi <= 10^9


3. 의사결정
    1) N을 받고, 두번째 줄 입력값을 공백으로 구분하여 배열과 최소힙에 넣는다.
    2) 최소힙에서 하나씩 빼면서 [뺀 값(실제 요소) + 순위(0부터 시작)]를 key, value로 hashmap에 넣는다.
    3) 리스트[i]를 key로 하는 value값을 뽑으면서 공백으로 구분하여 출력한다.

4. 문제 해결
    1) 좌표 압축 : 요소간의 순위를 유지하면서 더 작은 범위의 값으로 표현
    Ex) [2, 4, -10, 4, -9]  ---> [2, 3, 0, 3, 1]  * 최솟값 -10을 가장 작은 값 0으로 바꿈.
    2) hashmap에 value를 넣을 때 i로 넣지 말고, 0부터 시작하는 count 변수를 하나 따로 만들어야 한다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 주어지는 요소의 개수
        int N = Integer.parseInt(br.readLine());

        // 최소힙, 해시맵 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 요소 전체 입력받기
        String input = br.readLine();

        // 배열과 최소힙에 저장
        int[] arr = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < N; i++) {
            minHeap.add(arr[i]);
        }

        int number = 0;
        // 최소힙에서 꺼낸값 + 순위 -> hashmap에 저장
        for (int i = 0; i < N; i++) {
            // key가 이미 있을 경우 패스
            if (map.containsKey(minHeap.peek())) {
                minHeap.remove();
                continue;
            } else {  // key가 아직 없는 경우 추가
                map.put(minHeap.poll(), number);
                number++;
            }
        }

        StringBuilder sb = new StringBuilder();
        // 배열을 순회하면서, 기존값에 따른 압축값 출력
        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
