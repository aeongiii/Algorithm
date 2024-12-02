import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


/*
1. 문제 분석
    1) T개의 테스트케이스가 주어진다.
    2) 하나의 테스트케이스 안에서, [학교 이름 S + 술의 양 L]이 N줄 주어진다.
    3) 술의 양이 가장 많은 학교의 이름을 출력해야 한다.

2. 제약 조건
   1 <= N <= 100
   1 <= |S| <= 20
   0 <= L <= 10,000,000

3. 의사결정
    1) T를 입력받고, T만큼 for문을 돌린다.
    2) N을 받고, N만큼 [학교 이름 S + 술의 양 L]을 입력받는다.
    3) 술의 양은 모두 다르므로, key = L, value = S로 저장한다.
    4) L을 최대힙에도 저장한다.
    5) 최대힙에서 poll() 한 값을 key로 해서 value를 출력한다.



4. 문제 해결
    1)

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int i = 0; i < T; i++) {
            // 해시맵과 최대힙은 for문 안에서 만들어야 한다. (테스트케이스마다 초기화)
            HashMap<Integer, String> hashmap = new HashMap<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            // N 입력받기
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                // 한줄씩 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();
                int alcohol = Integer.parseInt(st.nextToken());

                // 저장
                hashmap.put(alcohol, schoolName);
                maxHeap.add(alcohol);
            }

            // 저장이 끝났다면 출력
            System.out.println(hashmap.get(maxHeap.poll()));
        }
    }
}