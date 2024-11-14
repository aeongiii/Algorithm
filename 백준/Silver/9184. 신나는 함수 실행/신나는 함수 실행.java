import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
1. 문제 분석
    1) a, b, c를 받아서 재귀함수를 실행한 뒤 출력형식에 맞게 결과를 출력한다.
    2) a, b, c = -1, -1. -1이 나올때까지 입력받는다.
    3) a, b, c 계산할때마다 배열에 저장하고, 가능한 계산된 값을 활용한다.

2. 제약 조건
   -50 <= a, b, c <= 50

3. 의사결정
    1) a, b, c가 각각 0부터 20까지인 3차원 배열을 만든다.
    2) for문을 만들고 a, b, c 입력받고, 한번 계산한 값은 저장해가면서 재귀함수를 호출한다.
        - a, b, c가 -1인 경우 프로그램 종료
        - a <= 0 or b <= 0 or c <= 0 인 경우 1 반환
        - a > 20 or b > 20 or c > 20 인 경우 w(20, 20, 20) 반환
        - a < b and b < c 인 경우 w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c) 로 재귀함수 호출
        - 그 외 : w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)로 재귀함수 호출

4. 문제 해결
    1) 처음에는 배열을 안 쓰고 해보려고 했는데 어려워서 메모이제이션 방식을 새로 배워 활용했다.
    2) for문을 통해 한번씩 입력받고 실행하는 것보다, 한번에 입력받은 뒤 순차적으로 실행하는 방식으로 수정했다.
 */

public class Main {

    static int[][][] memo = new int[21][21][21]; // 메모이제이션

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 a, b, c 저장할 리스트
        List<String> inputLine = new ArrayList<String>();


        // 한번에 입력받기
        String line;
        while (!(line = br.readLine()).equals("-1 -1 -1")) {
            inputLine.add(line);
        }

        // 입력받은 문자열을 한 줄씩 계산하고 값 출력
        for (int i = 0; i < inputLine.size(); i++) {
            String[] abc = inputLine.get(i).split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);

            // 출력
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }

    // 재귀함수
    public static int w(int a, int b, int c) {

        // 0이하 또는 20 이상인 경우
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 | b > 20 | c > 20) {
            return w(20, 20, 20);
        }

        // 이미 계산된 값이 있는 경우 활용한다.
        if (memo[a][b][c] != 0) {
            return memo[a][b][c];
        }

        // 이미 계산된 값이 없는 경우 새로 계산하고 저장한다.
        if (a < b && b < c) {
            memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }

        return memo[a][b][c];
    }

}