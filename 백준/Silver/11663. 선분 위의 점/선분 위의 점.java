
import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 점 N개, 선분 M개가 주어진다.
    2) M개의 선분위에 몇 개의 점이 있는지 구한다.

2. 제약 조건
    1 <= N, M <= 100,000
    같은 좌표의 점은 없다.


3. 의사결정
    1) 첫째줄에서 점의 개수 N과 선분의 개수 M을 받는다.
    2) 둘째줄에서 공백으로 구분하여 N개의 점 일차원 좌표를 입력받는다.
    3) 셋째줄부터 M개의 줄에 M개의 선분을 입력받는다.(시작점 + 끝점)
    4) 이분탐색을 하면서 각 선분 위에 몇개의 점이 있는지 출력한다.
    - 모든 점의 위치를 찾을때까지 mid를 조절하면 너무 오래걸린다.
    - 선분 위에 있는 점 중 첫번째 점 찾고 + 선분 위에 있는 점 중 제일 마지막 점 찾기
    - 일차원 좌표니까 첫번째 점 ~ 마지막 점 사이에 속한 점 모두 찾기
    - 이분탐색을 두번해야하는데?

4. 문제 해결
    1) 이분탐색하려면 정렬을 먼저 한 뒤에 탐색 시작해야 한다.
    2) 선분 정보를 저장하면서 동시에 탐색하려고 했는데 정렬 먼저!!
    3) 인덱스로 사용되는 변수를 그냥 정수로 사용하면 안된다... 변수명에 정확히 명시하기
    4) firstDotIndex, lastDotIndex의 초기값을 0으로 하면 안된다.


 */

public class Main {

    static int N, M;
    static int[] dot; // 각 점의 좌표 저장
    static List<int[]> line; // 선분 저장(시작점 + 끝점)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 점 개수
        M = Integer.parseInt(st.nextToken()); // 선분 개수

        dot = new int[N]; // 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dot[i] = Integer.parseInt(st.nextToken()); // 점 위치 저장
        }

        line = new ArrayList<>(); // 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            line.add(new int[]{start, end}); // 시작 + 끝 같이 저장한다.
        }

        // 정렬
        Arrays.sort(dot);

        // 각 선분에 대해
        for (int[] line : line) {
            int start = line[0];
            int end = line[1];

            // 이분탐색 시작
            int count = binarySearch(start, end);
            sb.append(count).append("\n"); // 한줄씩 출력
        }

        // 결과 출력
        System.out.print(sb);

    }


    static int binarySearch(int start, int end) {

        int left = 0, right = N - 1;

        // 선분 위에 포함되는 첫번째 점 찾기
        int firstDotIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2; // 인덱스로 사용할 mid를 일단 반 자름

            if (dot[mid] >= start) {
                firstDotIndex = mid; // 가운데 점이 선분 시작점 이상이라면 중간값 갱신
                right = mid - 1; // 탐색한 부분 이하부터 다시 탐색하도록 범위 조정
            } else {
                left = mid + 1; // 선분 시작점보다 작다면... 탐색한부분 이상으로 범위 조정
            }
        }

        // 다음 이분탐색(마지막 점) 을 위해서 초기화
        left = 0;
        right = N - 1;

        int lastDotIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2; // 반 자르고

            if (dot[mid] <= end) {
                lastDotIndex = mid; // 가운데 점이 선분 끝점보다 이하에 있다면 중간값 갱신
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // firstDot ~ lastDet 사이의 점 찾기
        // 선분 위에 점이 하나도 없을 경우
        if (firstDotIndex == -1 || lastDotIndex == -1 || firstDotIndex > lastDotIndex) {  // 인덱스가 넘어버리면 없는거
            return 0; // 0개 있다고 출력
        }

        return lastDotIndex - firstDotIndex + 1;

    }
}
