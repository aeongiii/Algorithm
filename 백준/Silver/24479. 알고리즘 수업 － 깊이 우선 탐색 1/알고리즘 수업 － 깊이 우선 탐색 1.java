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
    3) 방문처리할 리스트<Boolean>를 N+1크기로 만든다. 1번을 방문할 경우 인덱스1에 true 넣는다.
    3) R부터 시작한다.
        * [R]에 포함된 리스트 중 가장 작은 값부터 큰 값까지 [R].length번 돌린다. + 방문처리
        * 방문 안했던 곳이라면 재귀


4. 문제 해결
    1) visited의 경우 Boolean으로 해서 방문여부만 결정할지, 아니면 list에 방문한 순서대로 넣어서 방문여부+순서 모두 저장할지 고민
    => 방문하지 못하는 정점까지 확인하려면(0출력하려면) int[]배열을 사용해서 방문 순서만 저장하는게 나을지도??
    2) 방문할 수 없는 경우 0을 어떻게 넣지?
    => 카운팅++ 만들어서 저장해야겠다..
    3) count는 1부터 시작해야 한다.
 */

public class Main {

    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    static int N, M, R;
    static int count; // 방문 순서 카운트해서 저장



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 인접리스트 초기화 (N+1 크기로 만들어서 인덱스랑 일치시킴)
        list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
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

        // R부터 dfs 시작
        dfs(R);

        // 모든 재귀가 끝나고, 순서 출력 => 순서대로 출력하려면??
        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }



    static void dfs (int R) {

        // 방문체크 - 순서를 저장해야 하니까 카운팅 사용한다. 한번 방문할때마다 순서 ++해서 저장해야 중복X
        visited[R] = count++;

        // for문에서 사용하기 위해, R과 인접한 노드들 리스트 빼서
        ArrayList<Integer> newList = list.get(R);
        newList.sort(Comparator.naturalOrder()); // 오름차순 정렬 (오름차순으로 방문하니까)

        // 인접한 값들 중 최소값부터 돌면서
        for (int nextR : newList) {
            // 방문하지 않았다면(아직 nextR번째 인덱스에 순서가 저장되지 않았다면), 재귀호출
            if (visited[nextR] == 0) {
                dfs(nextR);
            }
        }

    }

}