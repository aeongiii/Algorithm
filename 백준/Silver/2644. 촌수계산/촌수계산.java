import java.nio.Buffer;
import java.util.*;
import java.io.*;


/*

1. 문제 분석
    1) 노드의 수 N, 촌수를 계산해야 하는 사람 a, b, 간선의 개수 M이 주어진다.
    2) 인접 리스트를 만들기 위해 이중리스트를 만든다.
    3) 4번째 줄부터 x, y를 입력받으면서 인접리스트에 저장한다.
    4) dfs를 반복하면서 a에서 b까지의 최소 거리를 찾는다.
    5) 만약 이어지지 않았을 경우 -1을 출력한다.

2. 제약 조건
    1 <= n <= 100

3. 의사결정
    1) N, a, b, M을 받는다. 방문처리할 visited 이중리스트도 만든다.
    2) 이중리스트 ArrayList<List<Integer>>을 만들고, 인접 리스트 형태로 저장한다.
    3) a부터 시작하여 dfs를 반복한다. 간선의 가중치는 없으므로 하나의 간선을 지날때 비용을 1씩 더한다.
     - 만약 b까지 이어지는 거리가 있을 경우 그 거리를 따로 저장해둔다.
     - 만약 b에 도착할 수 있는 거리가 여러개 있을 경우, 가장 짧은 거리로 갱신하고, 마지막에 그 값을 출력한다.
     - 만약 b에 도달할 수 없는 경우 -1을 출력한다.


4. 문제 해결
    1) 기본 촌수는 1이 아니라 0부터 시작한다. 재귀호출 할때마다 ++
    2) 최단 거리를 구해야하기 때문에 dfs보다 bfs가 더 적절했다.. bfs로 바꿔서 풀자
        * 큐에 배열을 넣어야 하나..?
    3) result 변수를 -1로 초기화하면 마지막 출력 때 더 간편했다
    4) a에서 출발 -> b를 찾는 데 성공했으면 found = true
    5) 한번 탐색이 끝났다면 while문 반복하면서 촌수도 증가해야 한다..
    6) queue_size가 유동적으로 변할 수 있으므로 미리 저장하기
 */

public class Main {

    static int N, M, a, b;
    static ArrayList<List<Integer>> list;
    static boolean[] visited;
    static int relative;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람수 N
        N = Integer.parseInt(br.readLine());

        // a, b
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        // 간선 수 M
        M = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화 (N+1크기로 인덱스 맞춤)
        list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }

        // 인접리스트에 x, y 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y); // 무방향이므로 양쪽에 모두 넣기
            list.get(y).add(x);
        }

        // 방문정보 저장할 배열 초기화 (N+! 크기)
        visited = new boolean[N+1];
        relative = 0;
        found = false;

        // bfs
        int result = bfs(a); // 기본 촌수 0에서 시작

        System.out.println(result);
    }



    static int bfs (int a) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a] = true;

        while (!queue.isEmpty()) {

            // 큐에 있는 노드(인접노드) 하나씩 빼면서 b인지 확인
            int queue_size = queue.size(); // 사이즈가 변할 수 있으므로 미리 저장해놔야 한다
            for (int i = 0; i < queue_size; i++) {
                int node = queue.poll();

                // b에 도착했다면 탈출
                if (node == b) {
                    found = true;
                    return relative;
                }

                // b에 도착하지 않았다면 인접노드 기준으로 다시 탐색
                for (int nextNode : list.get(node)) {
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.add(nextNode);
                    }
                }
            }
            relative++;
        }
        

        return -1;
    }
}