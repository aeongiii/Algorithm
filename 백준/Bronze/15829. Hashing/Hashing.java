import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 길이가 L인 문자열을 받아서, 각 알파벳에 대해 숫자를 부여(a=1, b=2...)한 뒤, 계산하여 해시 값을 정수로 출력한다.

2. 제약 조건
    1 <= small L <= 5
    1 <= large L <= 50

3. 의사결정
    1) 첫줄에서 L을 입력받는다.
    2) 둘째줄에서 문자열을 받는다.
    3) L만큼 for문을 돌리면서
        (1) 숫자로 바꾼 뒤 31^i만큼을 곱한다. => int로 가능한가..?
            * 숫자로 바꾸기 : a = 97, b = 98, ... , z = 122이므로 96만큼을 빼면 된다.
        (2) 누적한다.
        (3) 1234567891로 나눈다.?


4. 문제 해결
    1) 제곱하려면 Math.pow(double, double) 함수를 쓰면 된다. double로 나오기 때문에 int로 형변환 필요
    2) a=97을 a=1로 만들기 위해 아스키코드 96인 `(작은따옴표 아님...)을 빼는것도 가능하나, 코드에서 의도를 알 수 없기도 하고 생소했다.
       a - 96 으로 계산하거나, a - a + 1 로 계산하여 a=1을 구하는 방법이 더 적합하다!
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine()); // L 입력
        int sum = 0; // 누적할 변수

        String str = br.readLine(); // 문자열 받기
        for (int i = 0; i < L; i++) { // 문자열 각 글자에 대해
            int alphabet = str.charAt(i) - 96; // a = 97 ---> a = 1로 변경
            alphabet *= (int) Math.pow(31, i); // 31^i를 곱한 뒤 alphabet과 곱해준다.
            sum += alphabet; // 그 값을 누적
        }
        System.out.println(sum);
    }
}