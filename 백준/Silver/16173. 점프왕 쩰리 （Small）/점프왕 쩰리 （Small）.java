import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 길이가 N인 정사각형 게임 구역이 있다.
    2) 쩰리가 제일 왼쪽 위에서 시작한다. 각 칸에는 숫자 num이 쓰여있고, 딱 그 숫자만큼 움직여야 한다.
    3) 움직일때는 오른쪽 또는 아래로 움직일 수 있다.
    4) 딱 마지막 자리(오른쪽 아래)에 도착할 수 있다면 "HaruHaru", 없다면 "Hing"을 출력한다.

2. 제약 조건
   2 <= N <= 3
   0 <= num <= 100

3. 의사결정
    1) N을 받고, 길이가 [N][N]인 이중배열을 만든다.
    2) 이중배열 안에 공백으로 구분한 정수들을 넣는다.
    3) num = [x][y] 인 상태로, dfs 함수에 넣는다. 처음엔 [0][0]으로 넣는다.
      * dfs 함수 :: [x][y]에 써있는 숫자를 입력받고, 2번 for문을 돌려서 처음엔 오른쪽으로, 두번째는 아래쪽으로 dfs를 재귀호출한다.
                   성공하면 어디서든 true를 반환하고, 실패하면 false 반환한다.
    4) true/false에 맞는 출력값 반환

4. 문제 해결
    1) 0이 들어올 경우 dfs가 무한히 끝나지 않는다. 예외처리 필요
    2) 오른쪽 또는 아래로만 가기 때문에, 이전에 갔던 곳을 다시 가지 않는다. 방문했던 곳을 따로 표시할 필요 없다.
    3) 이동하고 난 새로운 위치 nx, ny는 0 이상, N 미만이어야 한다.
    그런데 0 <= nx < N && 0 <= ny < N 으로 조건을 같이줬더니 오류가 발생해서 따로따로 나눠서 조건을 걸었다.


 */

public class Main {

    static int N;
    static int[][] gameGround;
    static boolean[][] visited;

    // 이동 방향을 나타내는 벡터값. num과 곱해진 후 x(현재 위치)에 더해진다.
     // 0일 경우 : 움직이지 않는다. (0 * num = 0)이므로 0칸 움직일 수 있다.
     // 1일 경우 : 움직인다. (1 * num = num)이므로 num만큼 움직일 수 있다.
     // -1일 경우 : 반대쪽으로 움직인다. 좌표상 왼쪽이나 위쪽으로 간다.
    static int[] dx = {0, 1};  // 1트에는 가로열을 움직이지 않고, 2트에는 가로열을 움직인다.
    static int[] dy = {1, 0};  // 1트에는 세로열을 움직이고,     2트에는 세로열을 움직이지 않는다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N 받기
        gameGround = new int[N][N]; // 게임 구역 만들기
        visited = new boolean[N][N];

        // 게임구역에 숫자 저장
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            gameGround[i] = input;
        }

        // 최초 인덱스값 (출발지점) 생성
        int x = 0;
        int y = 0;


        System.out.println(dfs(x, y) ? "HaruHaru" : "Hing");


    }



    static boolean dfs(int x, int y) {
        // 몇칸 움직이는가?
        int num = gameGround[x][y];

        if (num == 0) { // 0일 경우 무한반복되므로, 0이 나오면 바로 Hing 출력되도록
            return false;
        }

        if (num == -1) { // -1일 경우 성공한 것이므로, 바로 HaruHaru 출력
            return true;
        }

        // 이동했을 때 배열 범위를 넘어버린다면, 움직이지 않는다.
        for (int i = 0; i < 2; i++) { // i=0일때는 오른쪽으로 움직이는 경우, i=1일때는 왼쪽으로 움직이는 경우이다.
            // 일단 이동한다.
            int nx = x + dx[i] * num;
            int ny = y + dy[i] * num;

            if (nx >= 0 && ny >= 0) { // 각 요소가 배열 안에 있을 때 (0이상 N미만)
                if (nx < N && ny < N) {
                    if (dfs(nx, ny)) {  // 새로운 위치로 이동하여 재귀 호출
                        return true; // 호출값이 모두 true로 나온다면, 최종 true 반환
                    }
                }
            }
        }
        // 다 돌았는데도 실패했다면 false
        return false;
    }

}

