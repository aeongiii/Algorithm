import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) 첫줄에 N이 주어지고, N개의 영단어 문장이 주어진다. 각 문장은 알파벳과 스페이스로 이루어져 있다.
    2) 스페이스는 문장의 처음과 끝에 위치하지 않는다.
    3) 각 영단어 문장에 대해, 단어를 역순으로 출력한다.
    4) 출력 시 "Case #X:"로 시작한다.

2. 제약 조건
    N = 5
    1 <= L <= 25

3. 의사결정
    1) BufferedReader를 사용하여 N을 입력받는다.
    2) N만큼 for문을 돌린다.
        (1) 스택을 선언한다.
        (2) 한문장 전체를 입력받고, 공백으로 구분하여 스택에 넣는다.
        (3) "Case #X:"와 함께 스택에 있는 것들을 꺼내 출력할 문장을 완성한다. (x = i)
        (4) Stringbuilder에 넣었다가 모든 for문이 끝나면 한번에 출력한다.

4. 문제 해결
    1) st.nextToken(br.readLine()) 꼬임 문제 : st.nextToken()은 이미 분리된 단어를 반환하고,
    br.readLine()은 "다음 줄을 읽는 것"이라 데이터가 꼬이게 된다. 디버깅 시에도 메모리에 남지 않아 확인이 어렵다.
        => br.readLine() 먼저 실행 후 st.nextToken() 실행
    2) StringBuilder sb = new StringBuilder("Case #" + i+1)로 선언할 경우, i=0일때 Case#01과 같이 출력되는 문제
        => 숫자로 들어가야하는 i+1은 따로 append 해준다.
    3) stack.size()를 기준으로 for문을 반복하고, for문 안에서 pop()을 실행하는 경우, for문이 수행될때마다 stack.size()도 감소하므로 반복문이 예상보다 빨리 끝나버린다.
        => stack.size() 대신 스택의 원래 사이즈를 고정적으로 저장하고 반복해야 한다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N 입력받기

        // 각 케이스에 대해 수행
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 줄 읽기
            StringTokenizer st = new StringTokenizer(line); // StringTokenizer 선언하여 공백 기준 자르기

            Stack<String> stack = new Stack<>(); // for문 안에서 스택 선언

            while (st.hasMoreTokens()) { // 읽어들일 토큰이 있을 경우
                stack.push(st.nextToken()); // stack에 넣기
            }

            sb.append("Case #"); // Case #X
            sb.append(i+1).append(": ");

            int size = stack.size();
            for (int j = 0; j < size; j++) { // 스택에 있는거 역순으로 빼서 출력문장 만들기
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }
}