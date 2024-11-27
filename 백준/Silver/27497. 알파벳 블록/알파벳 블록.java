import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 받기
        Deque<String> deque = new ArrayDeque<>(); // 문자열 관리에 ArrayDeque 사용
        Stack<Integer> stack = new Stack<>(); // 실행했던 규칙들 저장할 stack
        StringBuilder result = new StringBuilder(); // 출력 최적화

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 매번 새로운 입력 처리
            int button = Integer.parseInt(st.nextToken()); // 버튼 숫자 받기

            // 주어진 버튼에 따라
            switch (button) {
                case 1:
                    String str1 = st.nextToken(); // 문자열 받기
                    deque.addLast(str1); // 맨 뒤에 추가
                    stack.push(button); // 스택에 버튼 저장
                    break;

                case 2:
                    String str2 = st.nextToken(); // 문자열 받기
                    deque.addFirst(str2); // 맨 앞에 추가
                    stack.push(button); // 스택에 버튼 저장
                    break;

                case 3:
                    if (!stack.isEmpty() && !deque.isEmpty()) { // 스택과 덱이 비어 있지 않은 경우만 처리
                        int lastButton = stack.pop(); // 스택에서 최근 버튼 가져오기
                        if (lastButton == 1) {
                            deque.removeLast(); // 맨 뒤에서 제거
                        } else if (lastButton == 2) {
                            deque.removeFirst(); // 맨 앞에서 제거
                        }
                    }
                    break;
            }
        }

        // 출력 준비
        if (deque.isEmpty()) {
            System.out.println(0); // 빈 문자열일 경우 0 출력
        } else {
            for (String s : deque) {
                result.append(s); // StringBuilder에 추가
            }
            System.out.println(result); // 한 번에 출력
        }
    }
}