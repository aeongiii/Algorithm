/*
1. 문제 분석
    1) 테스트케이스 T에 대해, 첫째 줄에 V E 가 주어지고 둘째줄부터 E개 줄에 걸쳐 u v가 주어짐
    2) 여러개의 테스트케이스가 있다.
    3) 해당 그래프가 이분 그래프이면 YES, 아니면 NO를 출력한다.
    4) 이분그래프인지 아는 법
        - 이분그래프 : 그래프의 모든 정점이 두 그룹으로 나눠지고, 서로 다른 그룹의 정점이 연결되어있음
            = 인접한 정점끼리 칠하면 서로 다른색으로 칠해져야 함
            = 인접한 정점끼리 나누면 딱 두개로 나눠져야 함
            = 빨간색은 파란색이랑만 인접해야 하고.. 파랑은 빨강이랑만 인접해야 한다.
        - BFS, DFS를 사용해서 구할 수 있다.
            - 정점을 방문할 때마다 A 또는 B로 칠한다.
            - 다음 정점(인접)을 방문할 때는 자신과 다른 색으로 칠한다.
            - 탐색을 진행하다가,, 다음 정점(인접)이 자신과 같은 색이라면 바로 컷
            - BFS의 경우 같은 레벨에서 정점을 다른 색으로 칠해야 한다면 바로 컷
            * 근데 만약 비연결그래프라면 !! 모든 정점에 대해 확인해야 한다.

2. 제약 조건
    1) 2 <= K <= 5
    2) 1 <= V <= 20000
    3) 1 <= E <= 200000

3. 의사결정
    1) T를 입력받아서 while문 돌리기
    2) 첫줄에서 V E를 입력받고, V*V인 인접리스트 만들기
    3) E개의 줄을 입력받으면서 u v 입력받아서 (u, v)에 저장하기
    4) bfs 큐 사용해보기 ! 방문할때 색깔 확인하는 작업 진행해줘야 한다.
    5) 비연결 그래프일 경우... 어차피 이중배열 싹 돌면서 확인해야하나??


4. 문제풀이
    1) V가 최대 20000이라서 이중 배열을 쓰면 메모리 초과 가능성
    2) 빨강 1, 파랑 -1, 미방문 0

 */

import java.io.*;
import java.util.*;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 테스트케이스
        while(T-- > 0) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st1.nextToken());
            int E = Integer.parseInt(st1.nextToken());

            // 인접리스트 만들기
            ArrayList<Integer>[] graph = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>(); // 초기화
            }
            
            // 간선 연결정보 입력받기기
            for (int i = 0; i < E; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st2.nextToken());
                int v = Integer.parseInt(st2.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            // 방문 정보 입력할 visited 추가
            int[] color = new int[V+1];

            // 정답 TF 체크할 변수
            boolean result = true;

            // 비연결 그래프 있을 수도 있기 때문에 전체 돌면서..
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i, graph, color)) { // false 반환하면 이분그래프 아님
                        result = false;
                        break;
                    }
                }
            }
            System.out.println(result ? "YES" : "NO");
        }
    }

    private static boolean bfs(int start, ArrayList<Integer>[] graph, int[] color) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // 색깔 = 1

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) { // 같은 라인 다 돌면서

                if (color[next] == 0) {
                    if (color[now] == 1) { // 반대로 칠하기
                        color[next] = -1;
                    } else { // 반대로 칠하기
                        color[next] = 1;
                    }
                    queue.add(next);
                } 
                
                else if (color[next] == color[now]) {
                    // 같은 색 발견시 이분그래프 ㄴㄴ
                    return false;
                }

            }
        }
        return true; // 제대로 끝났다면 이분그래프 ㅇㅇㅇ
    }
}
