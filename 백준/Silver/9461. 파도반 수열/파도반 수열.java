/*
1. 문제 분석
    1) 첫 삼각형 변의 길이가 1이고, 그림과 같이 정삼각형을 계속 추가한다.
    2) P(N)을 구한다.(마지막 변의 길이)

2. 제약 조건
    1) 1 <= N <= 100

3. 의사결정
    1) 내가 찾은 규칙으로는,
    - 4번째 인덱스부터는, 해당 수에 [0번째 인덱스 값]을 더한 값이 다음 변이 된다.
    - 예 : P(5) = P(4) + P(0), P(6) = P(5) + P(1), ... , P(N) = P(N-1) + P(N-5) 

           
4. 문제풀면서 수정한 부분
    1) 인덱스 확인 잘하자... 각 테스트케이스의 결과는 P[N-1]로 출력해야 한다.
    2) 100까지 돌려보니 변의 길이가 기하급수적으로 늘어남 -> long으로 바꿨다.
 */

 import java.util.*;
 import java.io.*;

 public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] memo = new long[N];

            for (int i = 0; i < N; i++) {
                if (0 <= i && i <= 2) {
                    memo[i] = 1;
                } else if (i == 3 || i == 4) {
                    memo[i] = 2;
                } else {
                    memo[i] = memo[i-1] + memo[i-5];
                }
            }
            sb.append(memo[N-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
 }