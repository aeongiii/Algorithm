import java.util.*;
import java.io.*;


/*

1. 문제 분석
    1) 5x5 숫자판에서 임의의 위치에서 시작하여 상/하/좌/우로 총 5번 이동하면서 6자리 수를 만든다.
    2) 서로 다른 여섯 자리 수의 개수를 구한다.
     * 제자리에서 뛰는건 불가능
     * 왔던 곳을 다시 거쳐도 된다.

2. 제약 조건
    칸 숫자는 0부터 9까지

3. 의사결정
    1) 5x5 숫자판을 이중리스트에 담는다.
    2) 0,0에서 시작할때 ---> 마지막에서 시작할때까지 모두 시도한다. (int x, int y)
    3) int x, int y가 배열을 넘어가지 않는 선에서 상하좌우 모두 돌린다.
    4) 재귀 호출은 6번만 해야하니까 카운트 세야겠다.

4. 문제 해결
    1) StringBuilder 새로 만들어주면서 재귀 호출한다.
    2) 종료 조건 잘 설정해야 한다..

 */

public class Main {

        static String[][] ground;
        static Set<String> result;

        static int[] dy = {0, 1, 0, -1};// 동, 남, 서, 북
        static int[] dx = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();

        // 초기화
        ground = new String[5][5];
        result = new HashSet<>();

        // 숫자판 입력받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ground[i][j] = st.nextToken();
            }
        }

        // 0,0부터 끝까지 탐색
        Set<String> result_set = null;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, new StringBuilder());
            }
        }


        // 개수 출력
        System.out.println(result.size());


    }



    static void dfs (int x, int y, int count, StringBuilder sb) {

        // 아직 6글자가 완성되지 않았다면, 현재 위치에 있는 문자열 이어붙이기
        String here = ground[x][y];
        sb.append(here);
        // 완성된 6글자 문자열을 Set에 저장
        if (count == 6) {
            result.add(sb.toString());
            return; // Set 반환하고 탈출
        }

        // 입력받은 좌표에서 상하좌우 탐색하기 (배열 넘지 않는 선에서)
        for (int i = 0; i < 4; i++) {

            // 새로운 위치 좌표
            int nx = x + dx[i];
            int ny = y + dy[i];

            // for문 돌면서 동/남/서/북쪽으로 이동
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {

                dfs(nx, ny, count + 1, sb); // 재귀 실행
                sb.deleteCharAt(sb.length()-1); // 마지막 요소만 삭제
            }
        }
    }

}