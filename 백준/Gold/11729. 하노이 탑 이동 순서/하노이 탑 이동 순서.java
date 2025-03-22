/*

1. 문제 분석
    1) 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판들이 순서대로 쌓여있다.
    2) 한 번에 한개의 원판씩 옮기고, 항상 위의 것이 더 작아야 한다.
    3) 세번째 장대로 옮기는 최소 횟수 + 이동 순서를 출력한다.

2. 제약 조건
    1) 1 <= N <= 20

3. 최초 의사결정
    1) N을 입력받는다.
    2) hanoi(N, 1, 3, 2) 호출 (= hanoi(n, from, to, via))
        - hanoi(N-1, 1, 2, 3) 호출
        - sb.append(from).append(" ").append(to)
        - count ++
        - hanoi(N-2, 2, 3, 1) 호출


    3) 모든 재귀가 끝나면 count 출력, sb 출력



4. 문제풀면서 수정한 부분
    1) 원반이 저장된 것을 저장하지 않아도 되고 출력만 하면 된다. 배열 필요 없음!
    2) 재귀 호출 시 숫자를 직접적으로 넣는게 아니라 from, to, via 변수를 사용해서 넣어야 동적으로 입력된다.
    3) 

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoi(int N, int from, int to, int via){
        if (N==0) return;
        
        hanoi(N-1, from, via, to); 

        sb.append(from).append(" ").append(to).append("\n"); // 원반 이동
        count++;

        hanoi(N-1, via, to, from);
    }
}