import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) N개의 단어를 받아서, 각 단어가 "좋은 단어"인지 확인한다.
    2) 단어는 A와 B로만 구성되어있다.
    3) A와 B로 이루어진 단어를 한 글자씩 검사하여, 각 글자가 교차없이 짝지어지는지 확인한다.
    4) 좋은 단어의 개수를 세서 출력한다.

2. 제약 조건
    1 <= N <= 100
    단어의 길이는 2와 100,000 사이
    모든 단어 길이의 합 < 1.000.000

3. 의사결정
    0) 좋은 단어가 되려면 스택 안에 하나씩 쌓고 없앴을 때 남은것이 없어야 한다. 없앨 수 없거나, 남은것이 있다면 좋은 단어 X
    1) N을 입력받고 N만큼 for문을 돌린다.
    2) for문 안에서 단어를 받은 뒤, 단어의 길이만큼 돌면서 스택에 저장 또는 삭제한다.
        => A를 받으면 쌓고, 다시 A를 받으면 없애는 방식
    3) 단어의 i번째 글자가 스택의 맨 위 글자와 같을 경우 없앤다.
       단어의 i번째 글자가 스택의 맨 위 글자와 같지 않을 경우 쌓는다.
       마지막에 남는 단어가 있는지 확인한다.

4. 문제 해결
    1) Stack의 peek()메서드는 가장 위에 있는 요소를 제거하지 않고 가져온다. peek(-1)로 적을 필요 없다.
    2) 스택이 비어있을 경우를 가능한 꼭 확인해주자.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 받기
        int count = 0; // '좋은 단어' 개수 카운트

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>(); // 단어 바뀔때마다 스택 초기화
            String word = br.readLine(); // 단어 받기

            for (int j = 0; j < word.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == word.charAt(j)) { // 스택의 마지막 값과 단어의 해당 인덱스 값이 같은 경우
                    stack.pop(); // 짝지을 수 있으므로 없앤다.
                } else {
                    stack.push(word.charAt(j)); // 짝지어지지 않으므로 추가한다.

                }

            }
            if (stack.isEmpty()) { // 단어를 모두 돌았을 때, 스택에 남은게 없다면 개수 +1
                count++;
            }

        }
        System.out.println(count); // 출력
    }
}