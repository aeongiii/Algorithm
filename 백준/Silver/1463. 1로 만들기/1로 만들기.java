/*
1. 문제 분석
    1) 3가지 연산을 사용하여 정수 N을 1로 반드는 최소한의 연산 횟수를 구한다.

2. 제약 조건
    1) 1 <= N <= 10^6

3. 최초 의사결정
    1) 1 = 0번
    2 = 1번  2^1
    3 = 1번  3^1
    4 = 2번  2^2
    5 = 3번  2^2 + 1^1   5 -> 4 -> 2 -> 1
    6 = 2번  3^1 + 2^1   6 -> 2 -> 1
    7 = 2번  1 + 3^1 + 2^1
    8 = 3번
    9 = 3번
    10 = 3번   10 -> 5 -> 4 -> 2 -> 1
               10 -> 9 -> 3 -> 1


    1, 2, 3까지는 직접 넣고 /2, /3, -1 연산 만들기
    4부터는
    /2/2로 풀고
    5는 3 또는 2의 배수가 아니니까 -1 한 뒤 4로 풀고
    6은 3 또는 2의 배수니까 /3/2로 풀고

    while 돌리면서 3의 배수면 /3, 2의 배수면 /2, 그렇지 않으면 -1을 반복한다.


4. 문제풀면서 수정한 부분
    1) Math.min을 사용하는 방법까지는 맞았다! 생각한 풀이를 구현하는 연습을 더 해야 할 것 같다..
    2) while문을 사용하면 큰 숫자부터 처리하기 때문에 /2, /3의 경우가 아직 저장되지 않았을 수 있다.
       for문을 사용해서 작은 수부터 채워나가야 안전하다.
    3) dp[i]을 구할 때 +1을 해야 연산횟수가 하나 증가된 값이 저장된다.
    4) 2와 3으로 동시에 나누어 떨어질 경우에도 최소값이 보장된다.
    */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 0;

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1; 

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            } 
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}