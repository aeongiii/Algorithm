import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 카드 개수 N이 주어진다.
    2) N번동안 과일의 종류 S + 과일의 개수 X가 한 줄씩 입력된다.
    3) S는 STRAWBERRY, BANANA, LIME, PLUM 중 하나이다.
    4) 하나의 과일에 대해 정확히 5개의 그림이 있으면 Yes를, 그렇지 않으면 No를 출력한다.

2. 제약 조건
    1 <= N <= 100000
    1 <= X <= 5
    입력으로 주어지는 모든 수는 정수이다.

3. 의사결정
    1) 카드의 개수 N을 받고, N만큼 for문을 돌리며 한 줄씩 입력받는다.
    2) STRAWBERRY, BANANA, LIME, PLUM의 과일 개수를 하나씩 넣을 배열을 만든다. (map보다 배열이 메모리 적음)

4. 문제 해결
    1) 시간 복잡도 측면에선 같은데 배열, 리스트, Map 중 뭘 사용할까 하다가 조금 더 빠르게 접근 가능한 배열을 사용했다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] halligalli = new int[4]; // 순서대로 STRAWBERRY, BANANA, LIME, PLUM의 개수 표시할 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "STRAWBERRY":
                    halligalli[0] += Integer.parseInt(st.nextToken());
                    break;
                case "BANANA":
                    halligalli[1] += Integer.parseInt(st.nextToken());
                    break;
                case "LIME":
                    halligalli[2] += Integer.parseInt(st.nextToken());
                    break;
                case "PLUM":
                    halligalli[3] += Integer.parseInt(st.nextToken());
                    break;
            }
        }
        // 배열에서 5인 값이 있는지 확인
        boolean bell = false;
        for (int num : halligalli) {
            if (num == 5) {
                bell = true;
                break;
            }
        }

        // 결과 출력
        if (bell) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}