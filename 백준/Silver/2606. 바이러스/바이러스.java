import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 컴퓨터의 수 N, 간선의 수 M이 주어진다.
    2) 둘째 줄부터 연결된 컴퓨터 정보 a, b가 주어진다.
    3) 무방향 간선 그래프에서 1번 컴퓨터와 직/간접적으로 연결된 컴퓨터의 수를 구한다.

2. 제약 조건
    1 <= N <= 100

3. 의사결정
    1) N과 M을 받는다.
    2) M만큼 for문 돌려서 연결된 정보 받고, ArrayList<List<String>> 인접리스트에 저장한다.
    3) 방문했던 곳 저장하는 visited도 이중배열로 저장한다.
    4) 1번 컴퓨터부터 시작해서 dfs 적용한다.
    5) 배열 만들고, 1에서부터 출발해서 노드 i에 도착했다면 배열에 저장한다.
    6) 맨 마지막에 배열의 크기를 출력한다.

4. 문제 해결
    1) 도착 정보를 저장하는 배열을 따로 만들지 말고 visited를 활용하자
    2) 1번 컴퓨터는 제외하고 정답 출력하기

 */

public class Main {

    static int N, M;
    static ArrayList<List<Integer>> graph; // 인접리스트
    static boolean[] visited; // 방문 기록
    static int result; // 1번과 연결된 노드 수


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine()); // 컴퓨터 수 N
        M = Integer.parseInt(br.readLine()); // 간선의 수 M

        // 인접리스트 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결정보 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); // 무방향 그래프니까 양쪽에 다 넣음
            graph.get(b).add(a);
        }

        // 방문 배열 초기화
        visited = new boolean[N + 1];
        result = 0;

        // 시작 노드는 무조건 1번
        dfs(1);

        // 결과 출력
        System.out.println(result);
    }


    static void dfs(int X) {

        visited[X] = true; // 현재 노드 방문 처리

        // 연결된 노드 확인
        for (int nextNode : graph.get(X)) {
            if (!visited[nextNode]) { // 방문하지 않은 노드라면
                result++;
                dfs(nextNode); // 재귀호출
            }
        }

    }
}
