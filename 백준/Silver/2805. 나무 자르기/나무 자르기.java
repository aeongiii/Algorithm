import java.util.*;
import java.io.*;


/*

1. 문제 분석
    1) N개의 나무를 적당히 잘라 길이 M만큼 가져가려고 한다.
    2) N개의 나무의 각 길이가 N줄에 주어진다.
    3) 적어도 M만큼 가져가는 방법 중 최소한으로 나무를 자를 수 있는, 목재절단기 길이 H를 찾는다.
    4) 최대의 H를 출력한다.

2. 제약 조건
    1 <= N <= 1,000,000
    1 <= M <= 2,000,000 (2백만)
    0 <= 각 나무의 높이 <= 1,000,000,000 (10억)


3. 의사결정
    1) 일단 N, M, 그리고 각 나무의 길이를 받아서 배열에 넣는다.
    2) 최적의 값을 찾아야 하니까 이분탐색을 사용해보자.
    3) 일단 H = 가장 큰 나무길이 & 가장 작은 나무길이의 딱 평균으로 잘라본다
        - 너무 많이 잘랐다면 H를 줄인다.
        - 너무 조금 잘랐다면 H를 더 늘린다.
        계속 이분탐색하고, 가장 적절한 결과를 result에 저장해서 마지막에 반환한다.


4. 문제 해결
    1) 나무절단기에 설정한 길이보다 나무가 작다면 잘리지 않는다!
    2) 이분탐색을 반복할 때, mid의 값을 start나 end에 넣는게 아니라, mid +1이나 -1값을 넣어야 다시 탐색하는 부분을 줄인다..
    3) 한번의 탐색에서 잘린 나무 길이를 tree에 다시 넣으면 안된다!
    4) total 값도 초기화 해줘야한다.
    5) 필요 이상으로 잘랐다고 무조건 return은 아니다. 그중에 최적값 찾아야.
    6) start + end /2 한 값 = mid, mid가 결국 절단기 높이 H와 같다.
    7) 나무의 길이가 최대 10억이기 때문에 long으로 변경해야한다!
 */

public class Main {

    static int result_H, maxTree;
    static int n, m;
    static int[] trees;
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 기존 나무길이 저장할 배열
        trees = new int[n];

        // static 변수 maxTree 미리초기화
        maxTree = 0;


        // 기존 나무길이 입력받아서 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxTree = Math.max(maxTree, trees[i]); // 최댓값 발견할때마다 갱신
        }

        // 이분탐색 시작
        int answer = binary_search(0, maxTree);

        // 출력
        System.out.println(answer);
    }



    static int binary_search (int start, int end) {

        // 반씩 줄여가며 반복문 끝까지 실행
        while (start <= end) {

            // total값 초기화한 뒤 다음 이분탐색 시작
            total = 0;

            // 반 나누기 = 나무 절단기 길이.
            int mid = (start + end) / 2;

//            // 나무절단기에 길이 설정
//            int H = mid;

            // 나무 하나하나 자르기
            for (int tree : trees) {
                if (tree > mid) {  // 나무절단기에 설정한 길이보다 큰 나무만 잘린다.
                    total += tree - mid; // 잘린 나무는 total에 누적
                }
            }

            // total의 값이 적절한지 확인

            // 필요 이상으로 자른 경우
            if (total >= m) {
                result_H = mid; // 일단 출력대상으로 저장해둠
                start = mid + 1; // 시작부분 변경하고 다시 반복
            }
            // 부족한 경우
            else {
                end = mid - 1; // 끝부분 변경하고 다시 반복
            }
        }
        return result_H;
    }
}
