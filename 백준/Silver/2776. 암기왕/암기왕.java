import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) 테스트케이스 T
    2) 각 테스트케이스에서 수첩1에 있는 N개의 정수와 수첩2에 있는 M개의 정수가 주어진다.
    3) 수첩2의 각 정수에 대해 수첩1에 포함되어 있는지 확인하여, 포함되어 있으면 1, 없으면 0을 출력한다.

2. 제약 조건
    1 ≤ N, M ≤ 1,000,000
    모든 정수는 int 범위
    시간 복잡도를 고려해야 한다.

3. 의사결정
    1) 수첩1의 모든 정수를 HashSet에 저장한다.
    2) 수첩2의 각 정수에 대해 HashSet에 포함되어 있는지 확인한다.
    3) HashSet은 탐색 속도가 O(1)이므로 대량의 데이터를 처리하기에 적합하다.

4. 문제 해결
    1) HashSet을 사용하여 수첩1의 정수들을 저장한다.
    2) 수첩2의 정수들을 하나씩 HashSet에서 조회하여 결과를 출력한다.
    3) BufferedReader와 BufferedWriter를 사용하여 I/O 성능을 최적화한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트케이스 개수
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 수첩1 입력
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> notebook1 = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                notebook1.add(Integer.parseInt(st.nextToken()));
            }

            // 수첩2 입력 및 결과 출력
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int number = Integer.parseInt(st.nextToken());
                if (notebook1.contains(number)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}