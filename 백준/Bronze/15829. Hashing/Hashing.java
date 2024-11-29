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
        (3) 1234567891 (M) 으로 나눠야 한다.


4. 문제 해결
    1) (small L에서 해당)
        제곱하려면 Math.pow(double, double) 함수를 쓰면 된다. double로 나오기 때문에 int로 형변환 필요.
        => n이 50까지 커지는 large case의 경우, math.pow를 쓰면 안된다고 한다.
        제곱하는 값(i)가 50까지 커질 경우, double에서 가능한 자릿수를 초과할 수도 있어서 손실될 수 있기 때문이다.
        (double -> int로 변환할 경우에도 조금 손실될 수 있지만, long 계산의 경우 훨씬 많이 손실되기 때문 같다)
        => 대신 for문을 사용하여 반복계산 해주자.

    2) a=97을 a=1로 만들기 위해 아스키코드 96인 `(작은따옴표 아님...)을 빼는것도 가능하나, 코드에서 의도를 알 수 없기도 하고 생소했다.
       a - 96 으로 계산하거나, a - a + 1 로 계산하여 a=1을 구하는 방법이 더 적합하다!
    3) int로 계산했더니 부분성공했다. large L은 50 이하이므로, 전체 성공하려면 long타입으로 해야한다.
    4) 모듈러 연산 없이도 small case는 성공했지만 large는 자꾸 실패한다.
       모듈러 연산(/M)을 추가했지만 계속 틀림 ---> 알고보니 모듈러 연산은 %M을 해야한다고 한다. (해시함수 원리 자체가 나머지 개념에 기반한 원리니까)
        * 모듈러 연산을 어디에 추가해야 하는가? = 숫자가 엄청 커질 수 있는 곳. 따라서, 31의 i제곱 할때랑 누적합 계산할때 등등 넣어줘야 한다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long L = Long.parseLong(br.readLine()); // L 입력
        long calculation = 1; // 31의 i제곱만큼을 저장할 계수 선언. 곱셈해야 하니까 1로 초기화
        long sum = 0; // 누적할 변수
        long M = 1234567891;

        String str = br.readLine(); // 문자열 받기

        for (int i = 0; i < L; i++) { // 문자열 각 글자에 대해
            long alphabet = str.charAt(i) - 96; // a = 97 ---> a = 1로 변경

            // 알파벳에 r^i 곱해주기
            long number = alphabet * calculation; // a * r^i 계산
            number %= M; // 너무 커지지 않도록 M으로 나누기

            // 곱한 값을 sum에 누적하기
            sum += number; // 누적
            sum %= M; // 너무 커지지 않도록 M으로 나누기 ===> 이 값이 최종 출력된다.

            // ====== 다음 for문을 위한 r^i 미리 만들어두기 ======
            calculation *= 31;
            calculation %= M; // 너무 커지지 않도록 M으로 나누기
        }

        System.out.println(sum);
    }
}