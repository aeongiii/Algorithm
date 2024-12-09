import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 10 x 10 사이즈의 입력을 받는다. B(불난 곳), L(호수), R(바위)가 속해있고 나머진 .이다.
    2) L에서 B까지 가는 최소 거리를 구한다. R부분은 피해가야 한다.
    3) 대각선으로 못가고, 동서남북 방향으로 인접해있는 소가 있어야 한다.
    4) 최소한으로 지나가는 길 (.의 수)를 구한다.

2. 제약 조건
    농장 크기 : 10x10

3. 의사결정
    1) 가로세로가 10인 농장 정보를 이중리스트에 입력받은 뒤, B, L, R의 위치도 따로 저장한다.
    2) 시작점은 L을 기준으로 4방향이다.
    3) BFS를 사용해서 최소 거리를 구한다.
        - 빼서 -> 상하좌우 이동하고 -> 이동값이 괜찮다면 큐에 넣기
    4) 최소 거리를 출력한다.

4. 문제 해결
    1) 다음 큐에 넣는 조건 : 0 <= nx, ny <= 10 + 방문하지 않아야 + 바위(R)이 아니어야 한다.
    2) 이동할때마다 거리 ++, 최소 거리 구해줘야
    3) 시작점과 도착점은 L, B 기준으로 4방향이다!! (대각선은 X)
 */

public class Main {

    static char[][] farm;
    static int[][] distance;
    static int[] barn = new int[2];
    static int[] lake = new int[2];
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        farm = new char[10][10];
        distance = new int[10][10];

        // 기본 -1로 저장했다가 방문한 뒤에 그 거리 저장
        for (int[] d : distance) {
            Arrays.fill(d, -1);
        }

        // 입력받기
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                farm[i][j] = line.charAt(j); // 농장 정보를 저장
                if (farm[i][j] == 'B') { // 불난곳(도착지점) 나오면 따로 저장
                    barn[0] = i;
                    barn[1] = j;
                }
                if (farm[i][j] == 'L') { // 호수(출발지점) 나오면 따로 저장
                    lake[0] = i;
                    lake[1] = j;
                }
            }
        }

        // BFS 호출하고 출력
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 시작점(L) 먼저 넣는다.
        queue.add(lake);
        distance[lake[0]][lake[1]] = 0; // L에서 L까지의 거리는 0이다.

        // 모두 탐색할때까지 while문 반복
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // 4방향으로 이동할 수 있다.
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 배열의 범위를 벗어나지 않고 방문하지 않았으며 바위가 아니면 이동 가능
                if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10
                        && distance[nx][ny] == -1 && farm[nx][ny] != 'R') {
                    distance[nx][ny] = distance[current[0]][current[1]] + 1; // 거리 하나 증가시켜야!
                    queue.add(new int[]{nx, ny}); // 다음 위치를 큐에 추가
                }
            }
        }

        // B에 인접한 지점 중 최소 거리 계산
        int min_distance = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int nx = barn[0] + dx[i];
            int ny = barn[1] + dy[i];

            // B에 인접한 지점이 농장 범위 내에 있고 방문한 적 있다면 최소 거리 갱신
            if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10 && distance[nx][ny] != -1) {
                min_distance = Math.min(min_distance, distance[nx][ny]);
            }
        }

        return min_distance;
    }
}
