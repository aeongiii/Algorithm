import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 총 N번 버튼을 누른다. 누른 버튼에 대한 정보는 [1 c]와 같이 [버튼+해당문자]로 주어진다.
    2) 버튼 : 1이면 맨 뒤, 2면 맨 앞에 블록 추가. 3이면 가장 최근에 추가된 블록 제거.
    3) c는 알파벳 대문자 혹은 소문자이다.
    4) 빈 문자열로 시작하고, 빈 문자열일때 3을 누를 경우 동작x
    5) 완성된 문자열을 출력한다.

2. 제약 조건
    1 <= N <= 1,000,000

3. 의사결정
    1) N을 입력받는다.
    2) 요소의 삽입, 삭제가 빈번하므로 ArrayDeque가 좋겠다. (인덱스에 의한 접근 불가)
    3) N만큼 for문을 돌면서 주어진대로 문자열을 수정한다.
        (1) [1 c]가 주어질 경우, 공백을 기준으로 나누어 버튼과 문자를 각각 저장한다.
        (2) 버튼이 1 또는 2일 경우 LinkedList의 앞 또는 뒤에 알맞게 문자를 추가한다.
        (3) 버튼이 3일 경우 이전에 받아서 추가했던 것을 기억해서 빼내야 한다.
            = 그러려면 이미 시행된 버튼을 스택에 저장해야 한다.
    4) 즉, ArrayDeque와 stack을 사용해본다.


4. 문제 해결
    1) 시행된 버튼이 1 또는 2일 경우에만 스택에 쌓아야 한다. 스택에 3은 들어갈 필요 없다.
    2) 시행된 버튼이 1 또는 2일 경우에만 문자열을 받아야 한다. 3일 경우 문자열이 같이 주어지지 않기 때문에 오류가 발생할 수 있다.
    3) case 3일때 if(stack.pop()==1), else if(stack.pop()==2)처럼 작성했더니 T/F를 판별하는 과정에서 이미 꺼내버려 오류 발생.
        => 한번만 꺼낸 뒤 변수 lastButton에 저장해서 사용했다.
    4) ArrayDeque를 그대로 출력할경우 [a, b, c]로 출력된다. 문제에서는 문자열 그대로 출력하라고 했으므로 문자열로 변환해야 한다.
        => sout을 반복 호출하지 말고 Stringbuilder를 사용해 한번에 출력한다.
    5) 처음에는 LinkedList로 했었는데 시간 초과돼서 삽입, 삭제, 탐색에서 좀더 효율적인 ArrayDeque를 사용했다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 받기
        Deque<String> deque = new ArrayDeque<>(); // 문자열 만들 LinkedList
        Stack<Integer> stack = new Stack<>(); // 실행했던 규칙들 저장할 stack
        StringBuilder result = new StringBuilder(); // 출력 최적화

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // st 초기화 (재사용 불가)
            int button = Integer.parseInt(st.nextToken()); // 버튼 숫자 받기

            // 주어진 버튼에 따라
            switch (button) {
                case 1:
                    String str1 = st.nextToken(); // 문자열 받기 : 3일 경우에는 받을 문자열이 없으므로, case1과 case2 안에만 넣어줘야 한다.
                    deque.addLast(str1); // 문자열 맨 뒤에 str 저장
                    stack.push(button); // 스택에는 눌렀던 버튼 정보 저장
                    break;

                case 2:
                    String str2 = st.nextToken(); // 문자열 받기 : 3일 경우에는 받을 문자열이 없으므로, case1과 case2 안에만 넣어줘야 한다.
                    deque.addFirst(str2); // 문자열 맨 앞에 str 저장
                    stack.push(button); // 스택에 눌렀던 버튼 정보 저장
                    break;

                case 3:

                    if (!stack.isEmpty() && !deque.isEmpty()) { // 스택과 데크 안에 값이 있는 경우만 처리
                        int lastButton = stack.pop(); // 가장 최근 버튼 다시 가져오기
                        if (lastButton == 1) {
                            deque.removeLast(); // 맨 뒤 문자 제거
                        } else if (lastButton == 2) {
                            deque.removeFirst(); // 맨 앞 문자 제거
                        }
                    }
                    break;
            }
        }

        // 문자열 출력
        if (deque.isEmpty()) {
            System.out.println(0); // 비어있는 경우 0 출력
        } else {
            for (String str : deque) {
                result.append(str); // StringBuilder에 추가하여 출력
            }
            System.out.println(result);
        }
    }
}