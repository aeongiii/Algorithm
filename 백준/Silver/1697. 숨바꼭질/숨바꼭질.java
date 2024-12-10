import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 수빈이의 위치 N에서 K까지 이동하는 최소값을 찾는다.
    2) 수빈이가 걷는다면 1초에 한칸(양옆) 움직이고, 순간이동한다면 2X의 위치로 이동한다.
    3) 수빈이가 동생에게 이동하는 가장 빠른 시간을 구한다.

2. 제약 조건
    0 <= N <= 100,000
    0 <= K <= 100,000

3. 의사결정
    1) 첫줄에서 N과 K를 받는다.
    2) 최소를 사용하는거니까 bfs를 사용한다.
    3) 큐를 선언하고, 방문처리하고, 3가지 방법으로 포문 돌린다.
        - x-1, x+1하는 경우는 1초 누적
        - 2x 하는 경우에도 1초 누적! 어차피 똑같다. 횟수 세면 된다

4. 문제 해결
    1) distance++ 위치는 while문이 끝나고(큐가 모두 빌 때) 해야한다.
    2) bfs 자체가 최소를 보장하기 때문에 굳이 도착지점을 모두 모아서 최솟값을 출력하지 않아도 된다.
    제일 먼저 도착 -> 최소.
    3) line과 visited의 배열 크기를 N+1로 할거면 bfs안에서의 조건문도 맞춰줘야 한다.
 */

public class Main {

    static int N, K, distance;
    static int[] line;
    static boolean[] visited;
    static ArrayList<Integer> distanceArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        line = new int[100001];
        visited = new boolean[100001];
        distanceArr = new ArrayList<>();


        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 출발
        K = Integer.parseInt(st.nextToken()); // 도착

        // BFS 호출하고 출력
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 시작점(N) 먼저 넣는다.
        queue.add(N);
        visited[N] = true; // 방문처리

        // 거리 초기화
        distance = 0;

        // 모두 탐색할때까지 while문 반복
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨에 있는 노드들 -> 이 노드를 모두 사용하고 나면 distance++한다.



            for (int i = 0; i < size; i++) {

                int current = queue.poll();

                // K에 도착했다면
                if (current == K) {
                    return distance;
                }

                // 3방향으로 이동할 수 있다.
                for (int j = 0; j < 3; j++) {

                    int nx = 0; // 일단 선언해두고

                    if (j == 0){
                        nx = current - 1; // x-1로 이동
                    } else if (j == 1) {
                        nx = current + 1; // x+1로 이동
                    } else {
                        nx = current * 2; // 2x로 이동
                    }

                    // 배열의 범위를 벗어나지 않고 + 방문하지 않았다면 = 이동
                    if (0 <= nx && nx <= 100000 && !visited[nx]) {
                        visited[nx] = true; // 방문처리
                        queue.add(nx); // 이동할 위치 큐에 추가
                    }

                }
            }
            // 거리 증가
            distance++;
        }


        // 안씀
        return -1;

    }

}
