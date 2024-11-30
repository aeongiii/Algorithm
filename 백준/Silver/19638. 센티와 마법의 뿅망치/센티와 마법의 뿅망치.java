import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 인구 수 N과, 센티의 키 H, 횟수 제한 T가 주어진다. 두번째 줄부터 거인 N명의 키가 각 줄마다 주어진다.
    2) 가장 키가 큰 거인을 찾아 키를 반으로 줄이는 작업을 T번 수행한다. 수행 도중 3, 4를 매번 검사한다.
    3) 센티보다 큰 거인이 있는 경우 NO를 출력하고 가장 키큰 거인의 키를 출력한다.
    4) 센티보다 큰 거인이 없는 경우 YES를 출력하고 뿅망치를 사용한 최소 횟수 T를 출력한다.

2. 제약 조건
   1 ≤ N ≤ 10^5
   1 ≤ 센티의 키 H ≤ 2 × 10^9
   1 ≤ T ≤ 10^5
   1 ≤ 거인의 키 H ≤ 2 × 10^9

3. 의사결정
    1) 첫번째 줄에서 N, H, T를 받는다.
    2) 거인들의 키를 받아서 힙[N]에 넣는다.
    3) for문 (T)
        (1) 가장 큰 거인을 찾아서 /2한다.
            => 가장 큰 거인을 찾는 방법 : 최대 힙을 사용한다!

        (2) 가장 큰 거인의 키와 센티의 키를 비교한다
            - 센티가 더 큰 경우 -> "YES"와 count 출력 후 완전종료
            - 거인이 더 큰 경우 -> 계속 반복

        (3) 가장 큰 거인의 키가 1일 경우, 2로 나누지 X

    4) for문을 나왔다면, 뿅망치 횟수를 다 썼는데도 거인이 더 큰 경우이므로 NO와 가장 큰 거인의 키 출력 후 종료

4. 문제 해결
    1) break는 반복문 탈출, return은 메서드 종료, System.exit(0)은 실행 종료이다. 출력해야 할것들이 있기 때문에 return으로 해야한다.
    2) 조건에서 2 × 10^9는 매우 큰 숫자이므로 long을 사용해야 한다!
    3) while (T-- > 0) :: T를 하나씩 감소시키면서, T가 양수인 동안 while문 반복한다.
    4) 힙이 비어있는지 확인하는 로직이 필요하다...

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 거인의 수
        long H_centi = Long.parseLong(st.nextToken()); // 센티의 키
        int T = Integer.parseInt(st.nextToken()); // 뿅망치 한정 횟수
        int count = 0; // 뿅망치 사용 횟수

        PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 구현

        for (int i = 0; i < N; i++) { // 거인들의 키 받아서 넣기
            long H_giant = Long.parseLong(br.readLine());
            heap.add(H_giant);
        }

        while (T-- > 0) {
            long H_giant_taller = heap.poll(); // 가장 큰 거인의 키 뽑음

            // 가장 큰 거인의 키가 센티보다 작거나 같을 때 종료
            if (H_giant_taller < H_centi || H_giant_taller == 1) {
                heap.add(H_giant_taller); // 다시 힙에 넣음
                break;
            }

            H_giant_taller /= 2; // 뿅망치 사용
            heap.add(H_giant_taller); // 다시 힙에 넣음
            count++; // 사용 횟수 카운팅
        }

        // 뿅망치 사용 후 결과 확인
        if (heap.peek() < H_centi) {
            System.out.println("YES\n" + count);
        } else {
            System.out.println("NO\n" + heap.peek());
        }
    }
}