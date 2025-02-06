/*
1. 문제 분석
    1) N개의 수와 M개의 수가 주어질 때, N개의 수 중에서 각 M이 있는지 없는지 판별하여 각각 1 또는 0을 출력한다.

2. 제약 조건
    1) 1 <= N <= 100,000
    2) 1 <= M <= 100,000

3. 의사결정
    1) N을 입력받고, N만큼 for문 돌리면서 우선순위 큐에 넣는다
    2) M을 입력받고, 배열에 넣는다.
    3) N과 M에서 하나씩 뽑으면서,
    - n이랑 m이 같은 경우 찾았으니까 중단
    - n이 m보다 클 경우 없으니까 중단
    - 그렇지 않으면 반복해서 n 뽑으면서 m 찾기

4. 문제풀면서 수정한 부분
    1) M은 입력받은 순서대로 출력해야 하기 때문에 우선순위 큐 말고 배열에 넣어야 한다.
    2) 우선순위 큐를 뽑으면 되돌릴 수 없기 때문에 복사본을 만들어 사용한다.
    - 근데 이러면 시간초과 뜬다..
    3) 정렬해서 찾는 문제니까 이진 탐색을 해보자. 트리맵 사용(자동 정렬, 탐색속도빠름)

 */

 import java.util.*;
 import java.io.*;

 public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeN = new TreeSet<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeN.add(Integer.parseInt(st1.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i < M; i++) {
            arrM[i] = Integer.parseInt(st2.nextToken());
        }

        // M값이 트리 안에 있는지 없는지 확인하기
        for (int i = 0; i < M; i++) {
            if (treeN.contains(arrM[i])) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
 }