import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 가로 C, 세로 R인 잔디가 주어진다.
    2) 이 잔디에서 가로 또는 세로 방향으로 #이 있는 개수를 구한다.
    3) 가로와 세로 방향이 동시에 주어지지는 않는다.(두 덩어리가 인접하지 않으니까)\
    4) 총 덩어리 수를 센다.

2. 제약 조건
   1 <= R <= 100
   1 <= C <= 100

3. 의사결정
    1) 이중 배열을 만든다.
    2) 이중배열[0][0]부터 차례대로 돌면서 #이 있는 부분을 찾는다.
        - #을 발견했다면, 가로[0][1] 또는 세로 [1][0]에 #이 있는지 확인한다.
        - 만약 가로에 있다면, 그 다음 가로에도 있는지 쭉 확인한다.(#이 없어질때까지)
        - #이 없어지면 카운트 1 한다.
    3) 이 방식으로 끝까지 돌았다면 카운트 수 출력

4. 문제 해결
    1) ArrayIndexOutOfBoundsException 문제 - while문 조건을 바꾸어 배열 범위 벗어나지 않게 바꿈

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        String[][] grass = new String[C][];

        int count = 0;

        // 배열안에 내용을 받기
        for (int i = 0; i < C; i++) {
            grass[i] = br.readLine().split("");
        }

        // 배열 순회하면서 개수 세기
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {

                // # 발견 시 .으로 바꾸기
                if (grass[i][j].equals("#")) {
                    grass[i][j] = ".";

                    // 가로로 #이 더 이어져 있는지
                    int k = j + 1;
                    while (k < R && grass[i][k].equals("#")) { // 범위 벗어나지 않도록 변경
                        grass[i][j+1] = ".";
                    }

                    // 세로로 #이 더 이어져있는지
                    int l = i + 1;
                    while (l < C && grass[l][j].equals("#")) { // 범위 벗어나지 않도록 변경
                        grass[i+1][j] = ".";
                    }

                    // 한 덩어리 끝났으므로 카운팅
                    count++;
                }

            }
        }

        System.out.println(count);
    }
}