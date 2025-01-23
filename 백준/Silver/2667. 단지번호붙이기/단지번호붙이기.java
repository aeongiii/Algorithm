import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 크기가 N*N인 정사각형 모양의 지도에서 단지의 수와 각 단지 안의 집 수를 구한다.
    2) 집이 있는 곳은 1, 집이 없는 곳은 0
    3) 상하좌우로 집이 붙어있다면 같은 단지. 대각선은 x

2. 제약 조건
    1) 5 <= N <= 25

3. 의사결정
    1) N을 입력받고, N만큼 이중 배열을 초기화한 뒤 데이터를 입력받는다.
    2) 0,0 부터 차례대로 돌다가 집을 발견하면
    3) dfs 수행한다. 이번엔 스택 써보기! 방문처리는 0으로 바꾸기
    4) dfs 수행하면서 집의 개수를 세어서 배열에 저장한다.
    5) 모두 끝났으면 단지 개수 +1


4. 문제풀이
    1) dfs 탐색할때 조건 : 방문하지 않은 집인경우 && 배열 범위 안에 있는 경우 (0 아니고 1 이상이어야 함)
    2) 단지 안의 집 개수 세는 count = 1부터 시작해야 한다.
    3) StringTokenizer는  공백이 있어야만 가능하다. 공백 없이 주어지는 경우는 charAt 쓰기
 */

public class Main {

    static int N;
    static int[][] map1;
    static ArrayList<Integer> danji; // 총 몇개의 단지가 있는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 맵 초기화 (N+1 크기)
        map1 = new int[N + 1][N + 1];

        // 지도에 데이터 저장
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                map1[i][j] = line.charAt(j - 1) - '0'; // 공백 없이 입력된 숫자 하나씩 저장
            }
        }

        // danji 초기화
        danji = new ArrayList<>();

        // 지도 처음부터 끝까지 돌면서
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map1[i][j] == 1) {
                    // 새로운 단지를 찾았다!
                    dfs(i, j);
                }

            }
        }

        // 모든 탐색을 완료했으면 출력
        StringBuilder sb = new StringBuilder();
        sb.append(danji.size()).append("\n");

        // 오름차순 변경
        Collections.sort(danji);
        for (int i = 0; i < danji.size(); i++) {
            sb.append(danji.get(i)).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void dfs(int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j}); // 시작점 스택에 넣기
        map1[i][j] = 0; // 방문처리

        // 이번 단지에 몇개가 들었는지 집 개수 세기
        int count = 1;

        int[][] arr = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int x = pop[0];
            int y = pop[1];

            // 뽑은거랑 상하좌우로 인접한 것들 중 방문 안한거 있으면 스택에 넣기
            for (int k = 0; k < 4; k++) {
                int nx = x + arr[k][0];
                int ny = y + arr[k][1];
                // 1이고, 배열 범위 넘지 않는 경우
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && map1[nx][ny] == 1) {
                    stack.push(new int[]{nx, ny}); // 스택에 넣고
                    map1[nx][ny] = 0; // 방문처리
                    count++;
                }
            }
        }
        danji.add(count);
    }
}
