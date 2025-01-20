
import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) 첫째줄에서 정점 개수 N, 간선 개수 M, 시작 번호 V가 주어진다.
    2) M개의 줄에 걸쳐서 연결되는 두 정점의 번호가 주어진다.
    3) 첫째 줄에 DFS 수행한 결과 출력 - 방문된 점 순서대로 출력
    4) 둘째줄에 BFS.


2. 제약 조건
    1) 1 <= N <= 1000
    2) 1 <= M <= 10000
    3) 방문할 수 있는 정점이 여러개인 경우 작은 정점부터 방문한다.

3. 의사결정
    1) N, M, V를 받는다.
    2) N, N 크기의 불형 이차원 배열을 만들고 (a, b), (b, a)를 true로 바꾼다.
    3) dfs 함수를 만들고 호출한다. 더이상 방문할 점이 없는 경우 종료 -> 순서 출력한다.
    4) bfs 함수 만들고 똑같이 출력

4. 문제풀이
    1) dfs : 한 노드에 대해서 끝까지 탐색한 후 되돌아와서 다음 노드 탐색 (백트래킹).
    깊이 제한이 없는 경우 스택 오버플로우 가능성.
    * dfs 구현시 특징
        - for문 전에 방문처리 한다.
        - for문 돌려서 -> 연결되어있는데 방문 안했으면 바로 재귀호출 한다.
    2) bfs : 현재 노드에서 가까운 노드부터 탐색. 메모리 사용량이 많다.
    * bfs 구현시 특징
        - 시작 노드 방문처리한 이후에는 큐에 삽입할 때 방문처리 한다.
        - while문에서 큐 하나씩 꺼내서 -> for문 돌려서 -> 연결되어있는데 방문 안한거 있으면 큐에 추가한다.
 */

public class Main {

    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기 (N, M, V)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 작은 정점부터 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        visited = new boolean[N + 1];
        StringBuilder dfsResult = new StringBuilder();
        dfs(V, dfsResult);
        System.out.println(dfsResult.toString().trim());

        // BFS 수행
        visited = new boolean[N + 1];
        System.out.println(bfs(V));
    }

    private static void dfs(int node, StringBuilder result) {
        visited[node] = true; // DFS는 방문 처리 후 재귀 호출
        result.append(node).append(" ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, result);
            }
        }
    }

    private static String bfs(int start) {
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // BFS는 큐에 추가할 때 방문 처리

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true; // 큐에 추가할 때 방문 처리
                }
            }
        }
        return result.toString().trim();
    }
}
