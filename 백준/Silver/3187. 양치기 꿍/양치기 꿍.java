import java.util.*;
import java.io.*;


/*

1. 문제 분석
    1) 세로가 R, 가로가 C인 영역에 울타리(#), 양(K), 늑대(V), 빈공간(.)으로 구성되어 있다.
    2) 울타리로 구분된 공간 안에서 늑대보다 양이 많을 경우 늑대가 전부 잡아먹힌다.
       늑대가 양의 수와 같거나, 양이 더 적을 경우에는 양이 모두 잡아먹힌다.
    3) 살아남게 되는 양과 늑대의 수를 각각 순서대로 출력한다.

2. 제약 조건
    3 <= 세로 R, 가로 C <= 250

3. 의사결정
    1) 울타리 배열, 양 배열, 늑대 배열을 모두 만들고,
    2) 세로 R 가로 C인 문자열 이중배열 안에 영역 정보를 담으면서 + 울타리/양/늑대가 나오면 해당 좌표를 해당 배열에도 넣는다.
    3) 양 또는 늑대 한마리가 위치한 지점에서 출발하여, 상/하/좌/우로 탐색하면서 울타리가 있는 장소까지 확인한다.
    그때 양이 몇마리인지, 늑대가 몇마리인지 각각 카운트한다. + 동물을 발견해서 카운트했다면, 양 배열 또는 늑대 배열에 들어있던 그 동물의 좌표를 삭제한다.
    4) 상/하/좌/우를 모두 다 확인하면서 모든 방향에서 울타리를 확인했다면(=여기까지가 하나의 울타리 영역이라면)
    영역 안에서 카운트된 양과 늑대가 몇마리인지 확인하고, 양이 잡아먹히거나 늑대가 잡아먹힌 뒤 결과적으로 남은 동물의 수를 저장한다.
    5) 양 배열이나 늑대 배열에 남은 동물 좌표가 있다면, 그 동물을 기준으로 3-4번을 계속 반복한다. (재귀)

    (영역 하나를 탐색하면서 양/늑대의 수를 카운팅한다면 그 동물은 다음 탐색을 위한 좌표배열에서 빠지기 때문에,
    3-4번을 반복하면서 다음 영역을 탐색할수록 배열 안의 양/늑대의 수는 계속 감소한다.)
    6) 모든 영역을 다 탐색했고 양/늑대 배열에 아무 동물도 없다면 최종적으로 살아남게 되는 양과 늑대의 각각 최종 수를 출력한다.

4. 문제 해결
    1) 양 배열, 늑대 배열은 만들지 않아도 된다. 카운팅만 하면 됨
    2) if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || area[nx][ny] == '#')
    if 조건문을 나누고 싶었는데 나누면 &&처럼 들어가지기 때문에 하나의 if문에 여러 조건을 ||로 추가했다.
    3) 리턴값은 하나만 가능하기 때문에 하나의 배열 안에 양과 늑대의 수를 모두 넣어서 리턴했다.
    4) 논리 연산자의 우선순위 : ||보다 &&이 먼저 처리된다. -> 방지하기 위해 괄호로 그룹화 해줬다.

 */

public class Main {

    static char[][] area;
    static boolean[][] visited;
    static int R, C;
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};
    static int totalSheep;
    static int totalWolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 세로와 가로 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // static 변수 초기화
        area = new char[R][C];
        visited = new boolean[R][C]; // 방문한 곳 체크

        // 영역 정보 입력받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                area[i][j] = line.charAt(j);
            }
        }


        // 영역 다 돌면서 검사
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 아직 방문 안한 곳에 늑대 또는 양이 있다면
                if (!visited[i][j] && (area[i][j] == 'k' || area[i][j] == 'v')) {
                    // bfs 실행한 값을 result에 받아옴 [양의 수, 늑대 수]
                    int[] result = bfs(i, j);
                    int sheep = result[0];
                    int wolf = result[1];

                    // 둘 중 하나는 잡아먹힘, 살아남는 쪽을 total에 누적
                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                }
            }
        }

        // 출력
        System.out.println(totalSheep + " " + totalWolf);
    }



    static int[] bfs (int x, int y) {
        // 정수 배열 큐에 {x, y}크기의 배열 추가???????
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int sheep = 0;
        int wolf = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 현재 위치의 동물을 확인하고 카운팅
            if (area[cx][cy] == 'k') sheep++;
            else if (area[cx][cy] == 'v') wolf++;

            // 4방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 넘었거나, 이미 방문ㅇ했거나, 울타리인 경우 패스
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || area[nx][ny] == '#') {
                    continue;
                }

                // 그렇지 않다면 새롭게 방문처리
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        // 확인한 영역 안에서 양과 늑대가 각각 몇마리인지 출력
        return new int[]{sheep, wolf};

    }

}