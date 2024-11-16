
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) N주동안 매일 4명의 근무자가 일한다. 총 근무자의 수는 모른다.
    2) 각 근무는 4, 6, 4, 10시간으로 나누어져 있다.
    3) 각 근무자의 총 근무시간을 구하고, 공평한지 확인한다.
    4) 각 인원의 근무시간 차이가 12시간 이하면 공평한 것이다.

2. 제약 조건
    총 근무자 수 <= 100
    1 <= N <= 50

3. 의사결정
    1) N을 입력받고, 길이가 [N][7]인 2중배열을 만든다. -=> 필요한가...?
    2) 한줄씩 입력받으면서, 몇번째 줄인지 세야 한다.
       a번째 줄을 입력받을 때마다, a%4(=1, 2, 3, 4)로 구분하여 시간을 따로 계산한다.
       가령, 1번째 줄 입력 시 아침 시간 근무에 누적/ 2번째 줄 입력 시 점심시간 근무에 누적/ ... / a번째 줄 입력시 a%4번째 시간 근무에 누적
    3)
4. 문제 해결
    1) 근무표를 그대로 재현하기 위해 길이가 [N][7][4]인 3중배열을 만들려고 했는데 그냥 아침/점심/저녁/밤 따로따로 계산하는게 좋겠다.
    2) Collections을 잘 사용하자!!!!!
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 몇주까지 있는지 확인
        int n = Integer.parseInt(br.readLine());

        // 근무일수 누적하는 hashmap
        HashMap<String, Integer> workMap = new HashMap<>();

        // 입력받은 줄이 몇번째 줄인가?
        int line = 0;

        // N주동안 입력 처리
        for (int i = 0; i < n*4; i++) {
            // 한 줄 받기
            String[] workersInWeek = br.readLine().split(" ");
            line++;

            // 이 근무자가 어느 시간대 근무자인지 체크하고 근무시간 누적
            switch (line % 4) {
                case 1: // 아침 근무자
                    for (String worker : workersInWeek) {
                        workMap.put(worker, workMap.getOrDefault(worker, 0) + 4);

                    }
                    break;
                case 2: // 점심 근무자
                    for (String worker : workersInWeek) {
                        workMap.put(worker, workMap.getOrDefault(worker, 0) + 6);

                    }
                    break;
                case 3: // 저녁 근무자
                    for (String worker : workersInWeek) {
                        workMap.put(worker, workMap.getOrDefault(worker, 0) + 4);

                    }
                    break;
                case 0: // 밤 근무자
                    for (String worker : workersInWeek) {
                        workMap.put(worker, workMap.getOrDefault(worker, 0) + 10);

                    }
                    break;
            }
            // 근무자가 "-"인 요소는 삭제한다.
            workMap.remove("-");
        }

            // 아무도 근무하지 않은 경우 = 공평
            if (workMap.isEmpty()) {
                System.out.println("Yes");
                return;
            }

            // 최대근무자와 최소근무자 간 시간차 계산
            int maxWork = Collections.max(workMap.values());
            int minWork = Collections.min(workMap.values());

            // 12시간 미만 = 공평
            if (maxWork - minWork <= 12) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
    }

}