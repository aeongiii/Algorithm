/*
1. 문제 분석
    1) N*M 직사각형에서 가장 큰 정사각형을 찾아 크기를 출력한다.

2. 제약 조건
    1) 1 <= N, M <= 50

3. 최초 의사결정
    1) N과 M을 받고, N만큼 for문 돌려서 이중 배열에 받는다.
    2) 이중 for문을 만들어 모든 수를 돌면서,
    각 수에 대해 오른쪽/아래쪽 범위를 초과하지 않는 선에서 정사각형 꼭짓점을 찾는다.
    - 네 꼭짓점이 모두 같으면 크기를 구해서 저장한다.
    - 큰 정사각형을 발견할때마다 크기를 계속 최신화한다.
    3) 모두 돌고 나면 크기 출력. 기본 크기는 1

4. 문제풀면서 수정한 부분
    1) N과 M의 길이가 다르므로, 정사각형을 찾을 때 더 짧은 길이의 범위 안에서 돌아야 한다.

 */

 import java.io.*;
 import java.util.*;

 public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N+1];  // { , 42101, 22100, 22101}

        for(int i = 1; i < N+1; i++) {
            arr[i] = br.readLine();
        }

        // 크기 저장
        int size = 1;

        // 브루트포스
        for (int i = 1; i < N+1; i++) { // 세로
            for (int j = 0; j < M; j++) { // 가로
                // 출발점
                char start = arr[i].charAt(j);
                
                // 정사각형 변만큼 이동할 길이 (범위 : 1부터 M까지)
                int shortLine = Math.min(M-j, N-i+1);
                for (int k = 1; k < shortLine; k++) {
                    char right = arr[i].charAt(j+k); // j위치에서부터 k만큼 이동
                    char down = arr[i+k].charAt(j);
                    char diagonal = arr[i+k].charAt(j+k);

                    if (start == right && right == down && down == diagonal) {
                        int newSize = (k+1)*(k+1); // k만큼 이동했다면 한 변의 길이는 k+1
                        if(size < newSize) size = newSize; // 갱신
                    }
                }
            }
        }

        System.out.println(size);
    }
 }