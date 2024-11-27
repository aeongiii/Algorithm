import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 각 문장을 입력받는다. "."가 나올때까지 순차적으로 입력받는다.
    2) 입력받은 문장에 대하여 한글자씩 검사하면서 왼쪽 괄호와 오른쪽 괄호를 짝짓는다.
    3) 정확히 균형을 이룬다면 yes 출력, 그렇지 않다면 no 출력

2. 제약 조건
    문장의 길이 <= 100

3. 의사결정
    1) BufferedReader를 사용하여 온점 하나 "."만 입력될때까지 문장을 받는다.
    2) 각 문장을 받으면, 하나씩 검사하면서 괄호가 있는지 검사한다.
        -> 왼쪽 괄호 [, ( 가 있으면 스택에 쌓고, 오른쪽 괄호 ), ]가 있으면 왼쪽 괄호를 스택에서 없앤다.
    3) 단어의 마지막에 온점이 나오면 한 문장 검사를 끝낸다. => 검사 안해도 된다! 어차피 괄호만 확인하면 됨.
    4) 스택에 아무것도 없다면 yes, 무언가 남아있다면 no 출력
    4) 다음 문장 대신 온점 하나"."만 입력되면 끝낸다.

4. 문제 해결
    1) Stack의 peek()메서드는 가장 위에 있는 요소를 제거하지 않고 가져온다. peek(-1)로 적을 필요 없다.
    2) 스택이 비어있을 경우를 가능한 꼭 확인해주자.!!!
    3) (와 )가 짝지어진다고 해서 ==를 사용하면 안된다... 이런 말도안되는 실수를 ㅜㅜ
    4) 문장을 검사할때마다 yes 또는 no를 출력하기보다, boolean값을 이용하는게 깔끔하다.
    5) 각 문장 마지막 글자에 온점이 있는지는 검사하지 않아도 될 것 같다. 문장 길이만큼 for문을 돌고 있기 때문에!
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine(); // 문장 입력받기
            if (str.equals(".")) break; // 문장이 "."와 같다면 모든 문장 검사 완료! while문 탈출

            Stack<Character> stack = new Stack<>(); // 스택 선언
            boolean balance = true; // 균형 여부

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // 왼쪽 괄호의 경우, stack에 추가
                if (c == '(' || c == '[') {
                    stack.push(c);
                }

                // 오른쪽 소괄호의 경우
                else if (c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') { // 스택이 비어있지 않고, 짝이 맞는 경우
                        stack.pop(); // 짝 맞으니까 없애기
                    } else {
                        balance = false; // 안맞을 경우 No를 출력해야 하므로 false로 바꾸고 반복문 탈출
                        break;
                    }
                }

                // 오른쪽 대괄호의 경우
                else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') { // 스택이 비어있지 않고, 짝이 맞는 경우
                        stack.pop(); // 짝 맞으니까 없애기
                    } else {
                        balance = false; // 안맞을 경우 No를 출력해야 하므로 false로 바꾸고 반복문 탈출
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) balance = false; // 모든 검사를 마쳤는데 스택이 비어있지 않다면 false

            System.out.println(balance ? "yes" : "no"); // balance가 T일경우 yes를, F일경우 no를 출력한다.

        }
    }
}