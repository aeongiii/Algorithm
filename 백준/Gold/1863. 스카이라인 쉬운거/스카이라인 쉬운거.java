import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 입력값에서 y값을 잘 봐야 한다.
       y가 +1되면 높은 건물이 하나 더 생겼다는 거고, -1되면 건물 하나가 끝났다는 것
    2) 빌딩의 최소 개수를 구한다.

2. 제약 조건
   1 <= n <= 50,000
   1 <= x <= 1,000,000
   0 <= y <= 500,000

3. 의사결정
    1) N을 입력받고, N만큼 for문을 돌리면서 좌표를 입력받는다.
    2) 새로운 y값을 스택에 넣는다.
    3) 고도가 높아지면 스택에서 추가하고, 고도가 낮아지면 스택에서 뺀다.
    4) 스택에 추가할때마다 건물 카운팅을 추가한다.


4. 문제 해결
    1) up, down을 모두 세지 않고 스택을 활용해서 비교하면서 추가/삭제한다.
    2) 스택이 비어잇는 경우와 그렇지 않은 경우를 매번 확인해야 하는 것 같다.
    3) 스택에 일단 0을 넣고 시작해야 한다.

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 받기

        Stack<Integer> stack = new Stack<>(); // 스택 선언
        stack.push(0); // 0이 들어있는 상태로 시작해야 첫 건물부터 셀 수 있다.

        int countBuildings = 0;

        // N만큼 입력받기
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 입력받은 y가 스택에서 뽑은 값보다 작다면 스택에서 제거
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
            }

            // 입력받은 y가 스택에서 뽑은 값보다 크다면 스택에 추가, 건물개수 추가
            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
                countBuildings++;
            }
        }

        // 출력
        System.out.println(countBuildings);
    }
}