/*
1. 문제 분석
    1) 정사각형이 모두 같은 색으로 칠해져있지 않다면 계속 4등분해서 잘라낸다.
    2) 최종적으로 모든 색종이가 같은 색이라면, 하얀색 색종이의 개수와 파란색 색종이의 개수를 각각 구한다.

2. 제약 조건
    1) N = 2, 4, 8, 16, 32, 64, 128

3. 의사결정
    1) N을 받고 N만큼 for문 돌려서 이중배열에 받는다.
    - st 하기 전에 문자열로 받아서 하나의 색깔만 들어있는지 확인하고 카운팅, 만약 하나의 색깔만 있다면 바로 출력하기
    2) N/2 = 1이 아니라면, 하나의 색종이 크기에 대해 -> 이 색종이가 단색이 아니라면 repeat(시작점, 끝점, 길이) {
    - 각각에 대해 다시 repeat() 호출한다.
    }

    3) 단색이라면... 파랑 또는 흰색의 카운팅을 1 증가한다..?
           
4. 문제풀면서 수정한 부분
    1) 

 */

 import java.io.*;
 import java.util.*;

 public class Main {

    static int[][] paper;
    static int blue;
    static int white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        repeat(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void repeat(int startX, int startY, int N) {

        boolean w = true;
        boolean b = true;
        for (int i = startX; i < startX + N; i++) {
            for (int j = startY; j < startY + N; j++) {
                if (paper[i][j] == 0) {
                    b = false; // 흰색 부분 발견 시 파란 색종이는 될 수 없음
                } else {
                    w = false; // 파란 부분 발견 시 흰색 색종이는 될 수 없음
                }
            }
        }

        if (w) { // 모든 종이가 흰색이라면
            white++;
            return;
        }
        if (b) { // 모든 종이가 파란색이라면
            blue++;
            return;
        }

        // 그렇지 않으면 다시 분할
        int half = N/2;
        repeat(startX, startY, half);
        repeat(startX, startY + half, half);
        repeat(startX + half, startY, half);
        repeat(startX + half, startY + half, half);
    }
 }