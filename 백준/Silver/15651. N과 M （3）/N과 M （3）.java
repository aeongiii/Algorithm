/*

1. 문제 분석
    1) 1부터 N까지 자연수 중에서 중복 가능하게 M개를 고르는 수열을 사전순으로 모두 출력한다.

2. 제약 조건
    1) 1 <= M <= N <= 7

3. 최초 의사결정
    1) N과 M을 받는다.
    2) 길이가 M인 배열을 만든다.
    3) 인덱스 = 0일때 백트래킹 호출한다.
        - 인덱스 = M이라면 배열이 완성되었으므로 출력하고 리턴한다.
        - 1부터 N까지 for문 돌면서 해당 인덱스에 수를 넣고
        - 인덱스 + 1 해서 백트래킹을 재귀 호출한다.

4. 문제풀면서 수정한 부분
    1) 

*/

import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        backtracking(0);

        System.out.println(sb);
    }

    private static void backtracking(int index) {
        if (index == M) {
            for(int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[index] = i;
            backtracking(index + 1);
        }
    }
}
