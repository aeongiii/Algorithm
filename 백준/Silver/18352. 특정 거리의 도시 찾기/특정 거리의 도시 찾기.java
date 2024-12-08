import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) N개의 노드, M개의 단방향 간선이 있다.
    2) 둘째 줄부터 두개의 노드 A B가 주어진다. A에서 B로 이동하는 단방향 도로가 존재한다는 의미.
    2) 특정 노드 X에서 출발하여, 최단 거리가 정확히 K인 모든 도시의 번호를 출력한다.

2. 제약 조건
    2 <= N <= 300,000
    1 <= M <= 1,000,000
    1 <= K <= 300,000
    1 <= X <= N
    1 <= A, B, <= N

3. 의사결정
    1) 첫째 줄에서 N, M, K, X를 순서대로 받는다. 방문정보 저장할 이중리스트 만들기
    2) M만큼 for문을 돌리고 간선 정보를 받는다. 인접리스트(이중리스트) 만들고 단방향 간선 정보 넣기
    3) 최단거리를 찾아야 하기 때문에 BFS를 쓴다. BFS 호출한 값이 정확히 K인 경우는 따로 저장한 뒤 마지막에 출력한다.
    4) BFS 함수
        - 큐 만들고, 시작점 큐에 넣고, 시작점 방문처리.
        - while(큐가 빌 때까지) 돌려서 큐에서 하나 빼고 + 만약 범위 안에 있고 방문 안했으면
         -> 인접 다 큐에 넣고 방문처리
         -> 하나 지나갈때마다 카운트하면서 방문
         -> k번째 방문하는 애들은 무조건 result에 넣기.
         -> 모든 방문이 끝났다면 result 반환 및 출력
    5) result 오름차순 출력, 비어있다면 -1 출력

4. 문제 해결
    1) static으로 선언한 list는 초기화와 정보 저장 동시에 XX 초기화 후에 정보 저장하기
    2) 인덱스랑 숫자랑 헷갈려서 visited는 N+1크기로 맞춰서 인덱스랑 맞춘다.
    3) 시작 노드 X에서 각 노드까지의 최단거리가 몇인지 다 찾아야 한다. 카운트 말고 거리 저장하는 배열 따로 추가
    4) 거리 저장하는 distance 배열에 X부터 X까지의 거리도 0으로 저장한다. 없어도 되지만 있어야 인덱스 맞추기 편함
    5) K번째 이동했다고 해서 bfs를 끝내지 말고 계속 다 검사한다. K번째 이동한 경우에만 result에 넣는다..
 */

public class Main {

    static int N, M, K, X;
    static ArrayList<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드의 개수 N
        M = Integer.parseInt(st.nextToken()); // 간선의 개수 M
        K = Integer.parseInt(st.nextToken()); // 구해야 하는 최단거리 K
        X = Integer.parseInt(st.nextToken()); // 출발 노드 X

        // 인접리스트 만들기
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 인접리스트에 연결 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); // 단방향이니까 하나만 넣는다.
        }

        // 방문기록 초기화
        visited = new boolean[N+1];

        // bfs 호출
        ArrayList<Integer> result = bfs(X);

        // 오름차순 출력 또는 -1
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result); // 결과를 오름차순 정렬
            for (Integer integer : result) {
                System.out.println(integer);
            }
        }
    }

    static ArrayList<Integer> bfs(int X) {

        // 초기화
        int[] distance = new int[N+1]; // 각 노드까지의 거리 저장
        ArrayList<Integer> result = new ArrayList<>(); // 정답 모아서 반환할 리스트
        Queue<Integer> queue = new LinkedList<>(); // 큐 초기화

        // 시작 노드 큐에 넣기
        queue.add(X);

        // 방문
        visited[X] = true;

        // X에서 X까지의 거리는 0이다.
        distance[X] = 0;

        while (!queue.isEmpty()) {

            // 다음으로 방문할 노드
            int next_node = queue.poll();

            // 인접 노드 다 돌면서
            for (int n : list.get(next_node)) {

                // 아직 방문하지 않은 곳이라면
                if (!visited[n]) {
                    visited[n] = true; // 방문처리하고
                    distance[n] = distance[next_node] + 1; // 거리 갱신

                    // 이번이 K번째라면
                    if (distance[n] == K) {
                        result.add(n); // 정답 리스트에 현재 노드 저장
                    }

                    // 큐에 계속 이웃노드 추가하면서 bfs 진행
                    queue.add(n);
                }
            }
        }
        return result;
    }
}
