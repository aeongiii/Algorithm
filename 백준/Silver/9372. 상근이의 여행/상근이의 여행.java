import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 테스트케이스 T가 주어진다.
    2) 하나의 테스트케이스 안에서, 첫째줄에 국가의 수 N과 비행기 종류 M이 주어진다.
    3) M개의 줄에 왕복비행기 정보(a b)가 주어진다.
    4) 모든 국가를 다 방문할 때, 비행기를 최소로 타는 횟수
      * 방문했던 국가를 다시 방문해도 된다.

2. 제약 조건
   T <= 100
   2 <= 국가의 수 N <= 1000
   1 <= 비행기 종류 M <= 10000
   1 <= a
   b <= n
   a != b

3. 의사결정
    1) 순환될 가능성이 있으므로 "연결그래프"를 사용한다. 노드 = N, 간선 = 왕복 비행기 정보.
    2) 테스트케이스 T만큼 for 문을 돌린다.
    3) N과 M을 받고, M만큼 for문을 돌려서 비행기 정보를 모두 입력받는다. (사용x)
    4) 연결그래프기 때문에 최소 간선의 수는 N-1.


4. 문제 해결
    1) 이렇게 쉽게 풀어도 되나...?


 */



public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 테스트케이스 처리
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            System.out.println(N - 1); // 그냥 N-1 출력

            // M개의 비행기 정보는 읽지 않아도 됨
            int M = Integer.parseInt(input[1]);
            for (int j = 0; j < M; j++) {
                br.readLine();
            }
        }
    }
}