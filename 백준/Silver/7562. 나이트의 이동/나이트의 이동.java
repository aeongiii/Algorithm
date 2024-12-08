import java.nio.Buffer;
import java.util.*;
import java.io.*;


/*

1. 문제 분석
    1) 첫번째 줄에 테스트케이스 개수 T가 주어진다.
    2) 두번째 줄부터 3줄에 걸쳐 체스판 한 변의 길이 I + 나이트가 현재 있는 칸 x y, 나이트가 이동하려는 칸 x1 y1이 주어진다.
    3) 나이트는 상하좌우 2칸 + 좌우로 1칸 움직인다.
    4) 나이트가 x1 y1에 도착하기 위해 이동하는 횟수의 최소값을 출력한다.

2. 제약 조건
    4 <= I <= 300


3. 의사결정
    1) 일단 T를 받고 T만큼 for문 돌린다.
    2) I를 받고, 체스판 이중리스트[I][I]크기로 만든다.
    3) 최소 이동 횟수를 구하는거니까 Bfs를 사용하자.
    4) 시작 지점 x, y + 도착 지점 x1 y1 입력받는다.
    5) bfs(x, y) 호출한다.

    6) bfs에서 사용할 큐를 선언한다.
    7) 방문체크 한 뒤 while문 시작한다.(조건 : b에 도달할때까지)
    8) 특정 위치에서 8가지 방향으로 이동할 수 있으므로, for문을 8까지 돌린다.
    9) 각 움직일 방향을 큐에 넣는다?
    10) 체스판 범위를 넘지 않는 조건에서 움직이고, 움직일때마다 카운트 추가한다. (초기화 필요)
        * 이동 방법 : 방향별로 직진 2회 + 좌 또는 우 1회
    11) x1, y1에 도착했다면 반복문 탈출하고 그 횟수를 반환한다.
       도착하지 않았다면 계속 돈다.


4. 문제 해결
    1) 이동 방법을 직진 + 좌우 따로 하지 않고, 그냥 평소처럼 x,y값으로 설정한다.
    2) 큐에 새로 넣을 때 new int[]를 만들어서 넣어야 한다.
    3) moving_count 증가는 while문 다시 돌기 직전에.
    4) 이동 시 배열 넘지 않도록 범위 지정 꼭!!
 */

public class Main {

    static int x, y, x1, y1, I;
    static ArrayList<List<Integer>> chess;
    static boolean[][] visited;
    static int moving_count; // 이동횟수

    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            // I입력받기
            I = Integer.parseInt(br.readLine());

            // IxI 크기로 체스판 초기화
            chess = new ArrayList<>(I);
            for (int i = 0; i < I; i++) {
                chess.add(new ArrayList<>(I));
            }

            // 출발지점 x, y
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 도착지점 x1, y1
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            // 방문정보 초기화
            visited = new boolean[I][I];

            // 출발지점 기준으로 호출
            int result = bfs(x, y);

            // 출력
            System.out.println(result);


        }

    }


    static int bfs(int x, int y) {

        // 큐, 카운팅 초기화
        Queue<int[]> queue = new LinkedList<>();
        moving_count = 0;

        // {x, y} 큐에 넣고 시작
        queue.add(new int[]{x, y});

        // 방문
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            // 큐에서 좌표 뽑으면서 좌표 이동하기
            int queue_size = queue.size(); // 사이즈가 변할 수 있으므로 미리 저장해놔야 한다
            for (int i = 0; i < queue_size; i++) {
                int[] next_location = queue.poll();

                // b에 도착했다면 탈출
                if (next_location[0] == x1 && next_location[1] == y1) {
                    return moving_count;
                }

                // b에 도착하지 않았다면, 다음으로 이동할 수 있는 8가지 방향을 큐에 넣기
                for (int j = 0; j < 8; j++) {

                    // 다음 이동할 좌표 x, y 계산
                    int next_x = next_location[0] + dx[j];
                    int next_y = next_location[1] + dy[j];

                    // 아직 방문하지 않은 곳이라면
                    if (next_x >= 0 && next_x < I && next_y >= 0 && next_y < I) {
                        if (!visited[next_x][next_y]) {
                            visited[next_x][next_y] = true; // 방문
                            queue.add(new int[]{next_x, next_y});
                        }
                    }

                }
            }
            // 이동 횟수 ++
            moving_count++;
        }
        return moving_count;
    }
}