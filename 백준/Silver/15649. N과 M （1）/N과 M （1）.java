/*
1. 문제 분석
    1) 1부터 N까지의 자연수 중에서 M개를 고르는 경우의 수를 모두 구한다.

2. 제약 조건
    1) 1 <= M <= N <= 8

3. 최초 의사결정
    1) N과 M을 받고, 리스트를 만든다.
    2) 1부터 M까지 for문을 돌리고 i를 첫번째 숫자로 넣는다. + 리스트에서 -1해서 자릿수 되돌리기.
    3) 1부터 M-1까지 for문을 돌리고 리스트의 순서대로 두번째 숫자부터 넣는다. + 자릿수 되돌리기
    4) ... 마지막 자리까지 재귀적으로 호출한다.
    5) 다 모아서 한번에 출력한다.

4. 문제풀면서 수정한 부분
    1) 백트래킹 순서 : 현재 숫자를 리스트에 추가 (1) > 재귀호출해서 다음 숫자 선택 (12) > 재귀호출 끝난 뒤에 이전 자릿수로 되돌림 (1) > 다음 수 탐색(13)
    2) 자릿수를 이전으로 되돌리기 전에 재귀호출을 먼저 수행해야 한다!
    */


import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer> selected= new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 수열 만들기
        selectNum(0); // 현재 자릿수 위치
        System.out.println(sb);

    }

    // 숫자 만들기
    private static void selectNum(int depth) {
        
        // M자리 만들었을 경우
        if (depth == M) {
            for(int i : selected) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // M자리 아직인 경우
        for(int i = 1; i <= N; i++) {
            if (!selected.contains(i)) { // 중복이 아닌 경우
                selected.add(i); // 리스트에 넣고
                selectNum(depth + 1); // 다음 자릿수 재귀 호출
                selected.remove(selected.size() - 1); // 이전으로
            }
        }
        
        
    }
}