import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1. 문제 분석
    1) 정수 스택을 구현한 뒤, N개의 명령을 순차적으로 수행한다.
    2) 첫줄에 명령의 개수 n이 주어진다.
    3) push 명령의 경우 정수 x가 함께 주어지고, 나머지는 출력이 실행되어야 한다.

2. 제약 조건
    N <= 10000
    1 <= x <= 100000

3. 의사결정
    1) N을 입력받고, N만큼 for 문을 돌린다.
    2) for문 안에서 명령문을 한 줄씩 받는다. " "로 구분하여 문자열 배열에 저장한다.
    3) 배열[0]의 값을 기준으로 switch문을 실행하고, push 명령문의 경우 배열[1]의 값도 활용하여 수행한다.
    4) StringBuilder를 사용해서 출력은 한번만 하자.

4. 문제 해결
    1)

 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); // 스택 선언
        int N = Integer.parseInt(br.readLine()); // N 받기

        // N번 반복
        for (int i = 0; i < N; i++) {
            String s = br.readLine(); // 명령문 한 줄 입력
            String[] str = s.split(" "); // [0] : 명령문, [1] : 정수(push의 경우)

            switch (str[0]) {
                case "push": // 정수 넣기
                    stack.push(Integer.parseInt(str[1]));
                    break;
                case "pop": // 스택 비었을 경우 -1, 아닐경우 맨 위 꺼내서 출력
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size": // 개수 출력
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty": // 비었는지?
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top": // 스택 비었을 경우 -1, 아닐 경우 가장 위에 있는 정수 출력 (삭제x)
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}