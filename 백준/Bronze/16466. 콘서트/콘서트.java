import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


/*
1. 문제 분석
    1) N개의 티켓 번호가 공백으로 구분하여 주어진다.
    2) 팔리지 않은 티켓 중 가장 작은 번호를 출력한다.

2. 제약 조건
   1 <= 팔린 티켓 수 N <= 1,000,000
   1 <= 팔린 티켓번호 A <= 2,147,483,648 - 1  (int에 딱 들어감)

3. 의사결정
    1) 첫줄에서 N을 입력받고, 둘째 줄에서 팔린 티켓 번호들을 공백으로 구분하여 입력받는다.
    2) 티켓번호는 매우 많을 수 있으므로, 배열에 받은 뒤 정렬하면 비효율적이다. 입력받자마자 최소힙에 넣자.
    3) 모두 넣었다면, 최소힙에서 하나씩 빼면서 번호를 확인한다.
        - 첫번째 뽑은 값이 1이 아니라면 ===> 정답은 1
        - 첫번째 뽑은 값이 1이라면
            - 이미 뽑은 최소값과 다음에 뽑은 최소값을 비교하여 1만큼 차이나는지 확인한다. (이어지는 정수인지)
                - 1만큼 차이난다면 : 그 다음 최소값을 뽑는다.
                - 2 이상 차이난다면 : [이미 뽑은 최소값]의 +1 이 정답이다.

4. 문제 해결
    1) 만약 비어있는 수 없이 1부터 N까지 이어진다면, 가장 작은 수로 N+1을 출력해야 한다.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 입력

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소힙 생성

        // N개 모두 최소힙에 넣기
        for (int i = 0; i < N; i++) {
            minHeap.add(Integer.parseInt(st.nextToken()));
        }

        // 최소값 뽑아서 nowTicket에 넣음
        int nowTicket = minHeap.poll();

        // 최소값이 1이 아니라면, 정답은 1이므로 탈출 및 출력
        if (nowTicket != 1) {
            System.out.println(1);
            return; // 메서드 종료
        }

        // 최소값이 1이라면, 그 다음거 뽑아서 차이가 1만큼만 나는지 확인.
        while (!minHeap.isEmpty())  {

            int nextTicket = minHeap.poll();
            if (nextTicket - nowTicket > 1) {
                System.out.println(nowTicket + 1); // 2 이상 차이난다면, nowTicket + 1 만큼이 정답이다.
                break;
            }

            nowTicket = nextTicket;
        }

        if (minHeap.isEmpty()) {
            System.out.println(nowTicket + 1); // 만약 1부터 N까지 모든 수가 존재한다면, n+1을 출력해야 한다.
        }

    }
}