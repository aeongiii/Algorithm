import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) N개의 용액이 주어지고, 두 개의 용액을 혼합했을 때 특성값이 0에 가장 가까운 조합을 찾는다.
    2) 산성 용액(양수)과 알칼리성 용액(음수)이 섞일 수도 있고, 같은 종류의 용액끼리 섞일 수도 있다.
    3) 결과는 오름차순으로 출력해야 한다.

2. 제약 조건
    1) 2 ≤ N ≤ 100,000 (최대 10만 개의 용액)
    2) 용액의 특성값은 -1,000,000,000 이상 1,000,000,000 이하.
    3) 시간 복잡도는 O(N log N) 이하로 해결해야 함.

3. 의사결정
    1) 용액을 오름차순으로 정렬한다.
    2) 투 포인터 알고리즘을 사용하여 최적의 두 용액을 찾는다.
    3) 왼쪽 포인터(left)는 리스트의 처음부터 시작하고, 오른쪽 포인터(right)는 리스트의 끝에서 시작한다.
    4) 두 포인터의 합을 비교하며 최적의 값을 찾는다.

4. 문제 해결
    1) 정렬 후 투 포인터를 이용하여 두 용액의 합을 구하고, 0에 가까운 값을 찾는다.
    2) 만약 합이 0보다 작으면 왼쪽 포인터 증가, 0보다 크면 오른쪽 포인터 감소.
    3) 최소 차이를 갱신하며 최적의 조합을 저장한다.

5. 배운 것
    1) 투 포인터를 활용한 최적화된 탐색 방법.
    2) 이진 탐색과의 차이점: 이진 탐색은 특정 값을 찾는 것이고, 투 포인터는 범위 내에서 최적 조합을 찾는 데 유용함.

6. 문제풀이 팁
    1) 정렬 후 투 포인터 활용 O(N log N) + O(N) = O(N log N)으로 빠르게 해결 가능.
    2) 두 포인터 이동 원칙:
       - 합이 0보다 크면 오른쪽 포인터 감소.
       - 합이 0보다 작으면 왼쪽 포인터 증가.
    3) 출력 시 오름차순을 유지해야 한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 용액 배열 입력
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        // 용액을 정렬
        Arrays.sort(solutions);

        // 투 포인터 알고리즘
        int left = 0, right = N - 1;
        int closestSum = Integer.MAX_VALUE; // 최소 차이 저장
        int bestLeft = 0, bestRight = 0; // 최적 조합

        while (left < right) {
            int sum = solutions[left] + solutions[right];

            // 현재 합이 0에 더 가까우면 갱신
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                bestLeft = solutions[left];
                bestRight = solutions[right];

                // 만약 정확히 0이라면 종료 (최적값)
                if (sum == 0) break;
            }

            // 투 포인터 이동
            if (sum < 0) {
                left++;  // 합이 음수면 작은 값을 더 크게 만들어야 하므로 left 증가
            } else {
                right--; // 합이 양수면 큰 값을 줄여야 하므로 right 감소
            }
        }

        // 최적의 두 용액 출력
        System.out.println(bestLeft + " " + bestRight);
    }
}
