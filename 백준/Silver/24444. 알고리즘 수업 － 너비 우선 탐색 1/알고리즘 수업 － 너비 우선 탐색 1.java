import java.util.*;
import java.io.*;


/*

1. 문제 분석
    1) N개의 정점, M개의 간선, 시작점 R이 주어진다.
    2) U - V 간의 간선 정보가 주어진다.
    3) 인접 정점이 있다면 오름차순으로 방문한다. (작은것부터)
    4) 깊이 우선 탐색으로 노드를 방문할 경우의 방문순서 출력

2. 제약 조건
    1 <= M <= 200,000
    1 <= R <= N
    1 <= u, v <= N, u != v

3. 의사결정
    1) 정점 개수 N과 간선 개수 M, 시작점 R을 받는다.
    2) u-v를 받으면서 인접 리스트로 저장한다. N+1크기로 만들어서 인덱스와 일치시킨다.
        * [N]개크기의 리스트에 연결된 정보를 이중리스트로 저장한다.
    3) 방문 정보 저장할 배열을 N+1크기로 만든다. 1번을 방문할 경우 인덱스1에 몇번째 순서로 방문했는지 넣는다.
        * 몇번째 순서인지 카운트할 변수 필요하다.
    3) R부터 시작한다.
        * 큐에 R을 넣고 -> 방문처리하고 -> R과 인접한 노드들 죄다 넣고 -> 각각 방문처리하고... (반복)
        * 방문 안했던 곳이라면 재귀


4. 문제 해결
    1) dfs때와 달리, 큐에서 node를 먼저 뺀 뒤에 방문체크 해야한다.
    2) 큐는 LinkedList나 ArrayDeque로 구성하면 된다. ArrayDeque로 해보자.
    3) bfs 마지막 if문에 조건 추가 : 아직 방문하지 않았지만, 이미 큐에 포함되어있어서 곧 방문할 예정인 경우 굳이 큐에 한번 더 추가하지 않는다
    4) 시간 초과 해결법..
        - BFS 함수 안에서 매번 정렬하지 말고 처음 입력받을때 한번만 정렬한다.
        - 처음부터 정렬 자체를 안하도록 리스트<트리셋> 으로 저장한다.
        - sb에 모아서 한번에 출력
        - bfs 마지막 if문에 조건 추가했던거 삭제하고, 대신 "방문 예정"인거는 -1로 저장한다. 즉 0이었던게 방문예정이면 -1이 되고, 방문하면 1이 된다.
 */

public class Main {

    static Queue<Integer> queue;
    static ArrayList<TreeSet<Integer>> list;
    static int[] visited;
    static int N, M, R;
    static int count; // 방문 순서 카운트해서 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // u-v 입력받을 인접리스트 초기화 (N+1 크기로 만들어서 인덱스랑 일치시킴)
        list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new TreeSet<>());
        }
        // 방문리스트 초기화 (N+1 크기)
        visited = new int[N+1];
        count = 1; // 첫번째 순서는 1이 저장되어야 한다.

        // 간선 정보를 리스트에 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.get(U).add(V); // 무방향이므로 양쪽에 대칭적으로 넣어준다.
            list.get(V).add(U);
        }

//        // 안쪽 리스트 오름차순 정렬 (0번째는 어차피 암것도 안들어서 정렬 안해도됨)
//        for (int i = 1; i < N+1; i++) {
//            Collections.sort(list.get(i));
//        }

        // 큐 초기화
        queue = new ArrayDeque<>();

        // 첫 BFS 호출 시 : 큐에 시작점 넣기
        queue.add(R);

        // R부터 bfs 시작
        bfs();

        // 큐에 있는걸 모두 뽑아내고 나면 순서 출력 -> 0번째 빼고 1번째부터 끝까지.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }



    static void bfs () {

        // bfs에서는 재귀보다 while문으로 인접노드 저장 및 방문한다.
        while (!queue.isEmpty()) {

            // 제일 앞에있는거 빼서 방문체크
            int node = queue.poll();
            visited[node] = count++;

            // node와 인접한 노드들 가지고와서 오름차순 정렬한다.(문제에서 오름차순 방문한다고 함)
            TreeSet<Integer> newList = list.get(node);
//            newList.sort(Comparator.naturalOrder()); // 위에서 미리 정렬하는걸로 바꿈

            // node와 인접한 노드들 리스트 가져옴
            for (int nextNode : newList) {
                // 인접한 노드를 아직 방문하지 않았다면 queue에 넣기
                //아직 방문하지 않았지만 큐에 추가되어 있는경우(방문 예정인 경우) -1로 일단 바꿔둬서 큐에 여러번 추가되지 않도록 함.
                if (visited[nextNode] == 0) {
                    queue.add(nextNode);
                    visited[nextNode] = -1;
                }
            }
        }
    }
}