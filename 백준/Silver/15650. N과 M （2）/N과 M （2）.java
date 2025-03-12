/*

1. 문제 분석
    1) 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 모두 출력한다. 
    2) 각 수열은 오름차순으로 출력해야 한다.

2. 제약 조건
    1) 1 <= M <= N <= 8

3. 최초 의사결정
    1) N과 M을 받는다.
    2) 숫자를 저장할 배열 select
    3) 백트래킹 함수에 depth랑 start를 넣는다.
    4) depth = M이 될때까지 하나씩 넣고
    5) depth = M이 되면 출력한다.

4. 문제풀면서 수정한 부분
    1) 

*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] select;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        select = new int[M];

        backtracking(0, 1);
    }

    private static void backtracking(int depth, int start) {

        if (depth == M) {
            for (int num : select) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i <= N; i++) {
            select[depth] = i;
            backtracking(depth+1, i+1);
        }
    }
}