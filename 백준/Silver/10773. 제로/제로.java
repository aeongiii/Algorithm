/*
1. 문제 분석
    1) 부르는 숫자를 모두 받아 적는데, 0을 외치면 최근에 쓴 숫자를 지운다.
    2) 모든 수를 받아 적은 후, 그 수의 합을 구한다.

2. 제약 조건
    1) 1 <= K <= 100000
    2) 0 <= 외치는 수 <= 1,000,000

3. 의사결정
    1) K를 받고, K만큼 for문 돌린다.
    2) 한줄씩 숫자를 받고 스택에 넣는다. 만약 0이면 스택에서 pop한다.
    3) 합 출력

4. 문제풀면서 수정한 부분
    1) stack.size는 계속 변하기 때문에, 미리 size를 변수에 따로 넣어준 뒤 for문을 돌리자.

 */

 import java.io.*;
 import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack= new Stack<Integer>();

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
                continue;
            } else {
                stack.push(num);
                continue;
            }
        }

        int total = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            total += stack.pop();
        }
        System.out.println(total);
    }
}