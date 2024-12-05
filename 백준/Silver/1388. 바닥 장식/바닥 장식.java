import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 세로 N, 가로 M인 바닥 타일 모양이 주어진다.
    2) -가 연속해서 있다면 하나의 타일로 간주하고, |가 연속해서 있다면 하나의 타일로 간주한다.
    3) 총 필요한 타일의 개수를 출력한다.

2. 제약 조건
   1 <= 자연수 N, M <= 50

3. 의사결정
    1) 세로 N, 가로 M을 받고, String[N][M]을 만든다. 방문여부도 체크할 boolean[][]도 만든다.
    2) N과 M이 크지 않으므로, 한 방향으로 배열 끝까지 탐색하는 DFS가 적절할 것 같다.
    3) 이중배열[0][0]에 -가 나왔다면 같은 행 이어지는 곳까지 true로 바꾸고, 카운트 +1
    4)                |가 나왔다면 같은 열 이어지는 곳까지 true로 바꾸고, 카운트 +1
    5) 카운팅 출력

4. 문제 해결
    1) dfs는 현재 위치를 방문했다는 표시를 꼭 해야 한다.
    2) 이번 문제에서는 타일이 공백으로 구분되지 않았다. ""로 split한다.
    3) dfs 함수 내에서 재귀호출하는 if 조건문을 중복하여 써서 실패했다. 중복되는 코드를 삭제했다.
    4) 상하 또는 좌우로 양쪽 탐색 시 인덱스에 들어가는 dx, dy를 {-1, 1}로 꼭 해야하나?
       어차피 -1일때는 nx >= 0 && ny >= 0 조건에서 false라서 실행되지 않는다..
       그래서 이 부분을 모두 지우고 돌려봤는데 잘 되는 것 같다?

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        String[][] tile = new String[N][M];
        boolean[][] visited = new boolean[N][M];

        int count = 0;

        // 타일 그림 입력받기
        for (int i = 0; i < N; i++) {
            tile[i] = br.readLine().split("");
        }

        // 타일 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                String now_tile = tile[i][j];

                // - 타일 발견
                if (!visited[i][j] && tile[i][j].equals("-")) {
                    dfs(i, j, now_tile, tile, visited); // 해당 위치에서 DFS 시작
                    count++; // dfs 한번 끝났다면 덩어리 개수 증가
                }

                // | 타일 발견
                if (!visited[i][j] && tile[i][j].equals("|")) {
                    dfs(i, j, now_tile, tile, visited); // 해당 위치에서 DFS 시작
                    count++; // dfs 한번 끝났다면 타일 개수 증가
                }
            }
        }

        // 출력
        System.out.println(count);
    }

    static void dfs(int i, int j, String now_tile, String[][] tile, boolean[][] visited) {
        // 방문 처리
        visited[i][j] =  true;

        int[] di;
        int[] dj;

        // 어느쪽으로 이동할지(좌우 또는 상하) 설정해야 한다.
        if (now_tile.equals("-")){ // 좌우이동하는 경우 j값만 움직이면 된다.
            di = new int[]{0, 0};
            dj = new int[]{1};
        } else { // 상하이동하는 경우 i값만 움직이면 된다.
            di = new int[]{1};
            dj = new int[]{0, 0};
        }

        // -1일때 + 1일때 총 2번 검사한다.
        for (int k = 0; k < 1; k++) {
            int nx = i + di[k]; // 인덱스를 그다음 검사할 인덱스로 변경한다.
            int ny = j + dj[k];


//            if (nx >= 0 && ny >= 0) { // 배열 범위를 넘지 않고
                if (nx < tile.length && ny < tile[0].length) {
                    // 방문하지 않은 곳이고 + 같은 모양의 타일까지 있다면
                    if (!visited[nx][ny] && tile[nx][ny].equals(now_tile)) {
                        dfs(nx, ny, now_tile, tile, visited);
                    }
//                }
            }
        }

    }
}


