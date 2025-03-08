/*

1. 문제 분석
    1) N개의 스위치를 학생의 성별 / 번호에 따라 스위치 상태를 변경한 뒤, 전체 스위치 상태를 출력한다.

2. 제약 조건
    1) 1 <= 스위치 개수 <= 100
    2) 스위치 켜짐 = 1, 스위치 꺼짐 = 0
    3) 1 <= 학생 수 <= 100
    4) 남학생 = 1, 여학생 = 2
    5) 1 <= 학생이 받은 수 <= 스위치 개수

3. 최초 의사결정
    1) 스위치 번호 + 스위치 상태를 hashmap에 저장한다.
        - 스위치 개수 N을 받은 뒤, for문을 돌리면서 스위치 번호(i) + 스위치 상태를 입력받아 저장한다.
    2) 각 학생에 따라 스위치를 조작한다.
        - 학생 수 M을 받은 뒤, for문을 돌리면서
        - M = 1(남자)일 경우, k의 배수를 하나씩 올리면서 k <N인 동안 모든 스위치 상태를 바꾼다.
        - M = 2(여자)일 경우, k와 대칭을 0부터 하나씩 올리면서 k-i = k+i인 가장 큰 i를 찾아서 k-i 부터 k+i까지의 모든 스위치 상태를 바꾼다.
        - 만약 i=1도 대칭이 아닌 경우 k의 상태만 바꾼다. (i는 0부터 시작해야 한다)
    3) 최종 스위치 상태를 공백으로 구분해 출력한다.

4. 문제풀면서 수정한 부분
    1) 20개씩 출력하는 로직 추가

*/

import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Integer, Integer> map;
    static int N, M;

    private static void switch_girl(int num) {
        int times = 0;

        while (num - times >= 1 && num + times <= N && map.get(num - times).equals(map.get(num + times))) {
            times++;
        }

        int start = num - (times - 1);
        int end = num + (times - 1);

        for (int i = start; i <= end; i++) {
            map.put(i, map.get(i) == 0 ? 1 : 0);
        }
    }

    private static void switch_boy(int num) {
        int times = 1;

        while (num * times <= N) {
            int switchNumber = num * times;
            map.put(switchNumber, map.get(switchNumber) == 0 ? 1 : 0);
            times++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 스위치 개수

        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(i, num);
        }

        M = Integer.parseInt(br.readLine()); // 학생 수

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st2.nextToken());
            int num = Integer.parseInt(st2.nextToken());

            if (gender == 1) {
                switch_boy(num);
            } else {
                switch_girl(num);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(map.get(i)).append(" ");
            if (i % 20 == 0) sb.append("\n"); // 20개씩 출력
        }

        System.out.print(sb);
    }
}