import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) 랜선을 잘라 N개의 같은 길이의 랜선을 만들어야 한다.
    2) 주어진 K개의 랜선 길이를 기반으로, N개의 랜선을 만들 수 있는 최대 길이를 구한다.
    3) 이진 탐색을 사용해 최대 길이를 효율적으로 찾는다.

2. 제약 조건
    1 ≤ K ≤ 10,000
    1 ≤ N ≤ 1,000,000
    각 랜선의 길이는 2^31 - 1 이하의 자연수
    항상 K ≤ N

3. 의사결정
    1) 이진 탐색을 사용하여 랜선 길이의 최댓값을 찾는다.
    2) 주어진 길이로 랜선을 잘랐을 때 N개 이상이 되는지 확인한다.
    3) 조건을 만족하는 최대 길이를 업데이트한다.

4. 문제 해결
    1) 랜선의 길이를 기준으로 이진 탐색 범위를 설정한다.
    2) 중간값(mid)을 기준으로 랜선을 자르고, 만들어진 랜선 개수를 계산한다.
    3) N개 이상이 가능하면 길이를 늘리고, 불가능하면 줄인다.
    4) 최댓값을 출력한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lanCables = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lanCables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanCables[i]); // 랜선 길이 중 최댓값 저장
        }

        // 이진 탐색 초기값 설정
        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // 각 랜선을 mid 길이로 잘라서 얻을 수 있는 랜선 개수 계산
            for (int cable : lanCables) {
                count += cable / mid;
            }

            if (count >= N) { // N개 이상 만들 수 있으면
                result = mid; // 최대 길이 갱신
                left = mid + 1;
            } else { // N개를 만들 수 없으면
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
