/*
1. 문제 분석
    1) M * N 크기의 보드 내용을 입력받는다.
    2) 보드에서 8*8 크기로 잘라내어 체스판을 만들건데, W와 B가 번갈아서 칠해져 있어야 한다.
    3) 잘라낸 뒤 몇 개의 정사각형을 다시 칠하는 방식으로 체스판을 만든다면, 
       칠해야 하는 정사각형의 최소 개수는?

2. 제약 조건
    1) 8 <= N, M <= 50

3. 의사결정
    1) 첫줄에서 N과 M을 받는다. 보드 리스트를 만들어놓는다.
    2) N개의 줄에 걸쳐 보드 내용을 받아서 보드 리스트에 넣는다. = 이중리스트 만들기
    3) 보드 리스트의 0,0부터 완전탐색을 하면서 8*8크기만큼 확인해서 몇개를 바꿔야하는지 카운트한다.
    4) 카운트가 가장 작은거 하나만 남겨서 출력한다.

4. 문제풀이
    1) 

 */

import java.io.*;
import java.util.*;

public class Main {

    static String[] board;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // board 배열을 초기화 (NullPointerException 방지)
        board = new String[N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        // 최솟값 저장
        int minPaint = Integer.MAX_VALUE;

        // 8x8 크기의 모든 경우 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minPaint = Math.min(minPaint, chess(i, j)); // 지금까지의 최소값 vs 새로운 최소값 중 작은거만 남김
            }
        }

        // 결과 출력
        System.out.println(minPaint);
    }

    private static int chess(int a, int b) {
        int countW = 0; // 'W' 시작으로 설정할 경우 체스판 수정 횟수
        int countB = 0; // 'B' 시작으로 설정할 경우 체스판 수정 횟수

        // 8x8 크기의 체스판 검사
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[a + i].charAt(b + j);
                
                // (0,0), (0,2), (0,4), (0,6), (1,1), (1,3), (1,5) ... 짝수 위치는 W
                // (0,1), (0,3), (0,5), (0,7), (1,0), (1,2), (1,4) ... 홀수 위치는 B
                if ((i + j) % 2 == 0) {
                    if (current != 'W') countW++; // W이어야 하는데 다르면 count++
                    if (current != 'B') countB++; // B이어야 하는데 다르면 count++
                } else {
                    if (current != 'B') countW++;
                    if (current != 'W') countB++;
                }
            }
        }

        // 'W' 시작 vs 'B' 시작 중 최소값 반환 (둘중 최소값을 반환)
        return Math.min(countW, countB);
    }
}
