/*
1. 문제 분석
    1) 선분 위의 집들을 빨, 초, 파 중 하나로 칠해야 한다.
    2) 집마다 각 색깔로 칠할때의 비용이 주어질 때, 최솟값 출력하기'
    3) 이전 집과 색깔이 같으면 안됨

2. 제약 조건
    1) 2 <= N <= 1000
    2) 1 <= 집을 칠하는 비용 <= 1000

3. 최초 의사결정
    1) 첫째 줄에서 N을 받고, N만큼 for문을 돌리면서
    2) 각 줄을 받으면서 바로 계산하여 저장하자.
    3) 각 줄을 받고, 일단 이전 집과 같지 않다면 최소값 저장 시도한다. > 안되면 중간값 > 안되면 최대값
    4) 저장한 뒤에 비용 합산도 실행한다.
    --> 전체 확인 XX DP로 점화식 찾아서 풀어야 한다!

           
4. 문제풀면서 수정한 부분
    1) DP를 적용하여 최소 비용을 구하자면,
    hap = 이전 집을 다른 색으로 칠한 최소 비용 + 현재 색의 비용이다.

    dp[i][0] = i번째 집을 빨강으로 칠했을 때의 최소 비용 = min(dp[i-1][1], d[i-1][2]) + cost[i][0]
    dp[i][1] = i번째 집을 초록으로 칠했을 때의 최소 비용 = min(dp[i-1][0], d[i-1][2]) + cost[i][1]
    dp[i][2] = i번째 집을 파랑으로 칠했을 때의 최소 비용 = min(dp[i-1][0], d[i-1][1]) + cost[i][2]

    이렇게 해서 이중 테이블을 모두 채운 뒤.. 이중에서 최소값을 한번 더 구해서 출력한다.

 */

 import java.io.*;
 import java.util.*;

 public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3]; // 문제에서 주어지는 비용 저장하는 배열
        int[][] dp = new int[N][3]; // i번째 집을 j번째 색으로 칠할 때의 최소 비용 저장하기 (누적해서 저장된다)

        // 비용 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫번째 dp는 누적되지 않으므로 초기값 그대로 복사
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // dp 계산하기
        for (int i = 1; i < N; i++) { // 0은 이미 복사했으니까 뺀다.
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0]; // 빨강일 때
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1]; // 초록일 때
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2]; // 파랑일 때
        }

        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(result);
    }
}