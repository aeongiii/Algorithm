/*

1. 문제 분석
    1) N종류의 동전으로 K원을 만들 때, 동전 개수의 최솟값을 구한다.

2. 제약 조건
    1) 1 <= N <= 10
    2) 1 <= K <= 100,000,000
    3) 1 <= 동전의 가치 <= 1,000,000
    4) A1 = 1

3. 최초 의사결정
    1) 첫째 줄에서 N과 K를 받는다.
    2) N만큼 for문 돌면서 길이가 N인 배열에 각 동전의 가치를 넣는다.
    3) while문 돌면서 제일 큰 가치와 K을 비교한다.
        - 가치가 더 크다면 pass 
        - K가 더 크다면, K / (가치) 계산해서 몫만큼을 result에 추가하고, 가치*몫만큼을 K에서 뺀다.
        - K = 0이 될때까지 돈다. (0이 안되는 경우는 없다.)
    4) 개수를 출력한다.

4. 문제풀면서 수정한 부분
    1) 

*/

import java.util.*;

public class Main {

    static int N, K, total;
    static int[] coinArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        total = 0;

        coinArr = new int[N];

        for (int i = 0; i < N; i++) {
            int coin = sc.nextInt();
            coinArr[i] = coin;
        }

        func();

        System.out.println(total);
        
    }
    private static void func() {
        int idx = N-1;

        while (K != 0) {
            int value = coinArr[idx];
            if (K < value) {
                idx--;
                continue;
            }

            int many = K / value;
            total += many;

            K -= many * value;

            idx--;
        }
    }
}
