import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) N개의 강의를 M개의 블루레이에 나눠 담는다.
    2) 강의 순서는 유지되어야 하며, 연속된 강의를 하나의 블루레이에 넣어야 한다.
    3) 모든 블루레이의 크기가 같아야 하며, 크기를 최소로 해야 한다.

2. 제약 조건
    1 ≤ N ≤ 100,000
    1 ≤ M ≤ N 
    각 강의 길이는 10,000 이하

3. 의사결정
    1) 블루레이 크기의 최솟값을 이진 탐색으로 찾는다.
    2) 최소 크기는 가장 긴 강의(최소 블루레이 크기)부터 시작한다.
    3) 최대 크기는 모든 강의를 하나의 블루레이에 담는 경우(총 길이)로 설정한다.
    4) 중간값(mid)을 블루레이 크기로 설정하고, 해당 크기로 블루레이를 M개 이하로 나눌 수 있는지 확인한다.
    5) 가능한 최소 블루레이 크기를 찾는다.

4. 문제 해결
    1) 블루레이 크기의 최소 범위는 max ~ sum
    2) 이진 탐색으로 mid 값을 설정하고, 블루레이 개수를 계산한다.
    3) 블루레이 개수가 M개 이하이면 크기를 줄이고, 크기가 부족하면 증가시킨다.


6. 문제 풀이
    1) 가능한 최소 블루레이 크기를 이진 탐색으로 찾는다.
    2) 최소 크기의 시작점: 가장 긴 강의의 길이.
    3) 최대 크기의 끝점: 모든 강의를 하나의 블루레이에 담았을 때.
    4) 블루레이 개수를 그리디 계산하여 개수를 맞춘다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 강의 개수 N, 블루레이 개수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 강의 길이 입력
        int[] lessons = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxLesson = 0;
        long sumLessons = 0;

        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            maxLesson = Math.max(maxLesson, lessons[i]); // 가장 긴 강의 길이 저장
            sumLessons += lessons[i]; // 강의 길이 총합 저장
        }

        // 이진 탐색 범위 설정
        long left = maxLesson; // 최소 블루레이 크기 = 가장 긴 강의
        long right = sumLessons; // 최대 블루레이 크기 = 모든 강의를 한 블루레이에 담는 경우
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            // 현재 mid 크기로 블루레이를 만들었을 때 몇 개가 필요한지 확인
            int count = countBluRays(lessons, mid);

            if (count <= M) { // M개 이하로 블루레이를 만들 수 있다면 크기를 더 줄일 수 있음
                result = mid;
                right = mid - 1;
            } else { // 블루레이 개수가 부족하면 크기를 늘려야 함
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    // 블루레이 크기를 size로 설정했을 때 필요한 블루레이 개수를 계산하는 함수
    private static int countBluRays(int[] lessons, long size) {
        int count = 1;
        long sum = 0;

        for (int lesson : lessons) {
            if (sum + lesson > size) { // 현재 블루레이에 더 담을 수 없다면 새로운 블루레이 사용
                count++;
                sum = lesson;
            } else {
                sum += lesson;
            }
        }

        return count;
    }
}
