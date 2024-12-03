import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) T개의 테스트케이스 안에서, 두 줄이 주어진다. 첫줄에는 K가 주어지고, 두번째 줄에는 K개의 파일 크기가 주어진다.
    2) 모든 장을 합치는 데 필요한 최소비용을 출력한다.
        => 아마 작은 파일부터 합쳐야 최소비용을 줄일 수 있을 듯 하다. 여러번 누적합을 계산해야 하니까..

2. 제약 조건
   3 <= K <= 1,000,000
   각 파일 크기 <= 10,000

3. 의사결정
    1) T를 입력받고, T만큼 for문을 돌린다.
    2) 첫째줄에서 K를 입력받고, 둘째줄에서 K만큼을 최소힙에 저장한다.
    3) 두개씩 빼면서 그 값을 누적 및 최소힙에 다시 저장한다.
    4) 하나 남을 때까지? 이 과정을 반복한다.
    5) 비용을 출력한다.

4. 문제 해결
    1) 최대힙 아니고 최소힙으로..
    2) 최소힙 하나로도 가능했다. 최소힙 하니까 반복문이 3개 이상 겹쳐서 매우 비효율적이다.
    3) 반례를 못찾겠다ㅠㅠㅠ
    4) long으로 바꿈

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 받기
        int T = Integer.parseInt(br.readLine());

        // 최대힙 생성
        PriorityQueue<Long> minQueue = new PriorityQueue<>();

        // 테스트케이스마다
        for (int i = 0; i < T; i++) {

            int K = Integer.parseInt(br.readLine()); // K 받기
            long totalOutput = 0;

            // 모든 정수 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (K-- > 0) {
                long number = Long.parseLong(st.nextToken());
                minQueue.add(number);
            }

            // 1개 남을 때까지 모든 수를 더해서 합산
            while (true) {

                // 모두 합산해서 1개만 딱 남았다면 그거 출력
                if (minQueue.size() == 1) {
                    System.out.println(totalOutput);
                    minQueue.clear();
                    break;
                } else {
                    // 아직 2개 이상 있다면 계속 2개씩 합산
                    long sum = minQueue.poll() + minQueue.poll();
                    minQueue.add(sum);
                    totalOutput += sum;
                }

            }

        }

    }

}