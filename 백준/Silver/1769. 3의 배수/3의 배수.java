import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 문제 분석
    1) 주어진 수가 3의 배수인지 알아내기 위해, 자릿수를 모두 더해서 나온 "한 자리 수"가 3의 배수인지 구해야 한다.
    2) 한 자리 수가 될 때까지 계속해서 자릿수를 더해야 하며, 이 작업을 몇번 반복했는지도 출력해야 한다.
    3) 주어진 수가 3의 배수라면 YES, 아니라면 NO를 출력한다.

2. 제약 조건
    자연수 X <= 1.000.000

3. 의사결정
    1) 주어진 수 number를 입력받는다. => String으로 입력받아야 길이 재기 편하다.
    2) 다 더한 숫자가 "한자리 수가 될 때까지" while문을 반복한다.
        (1) for문을 사용하여 number를 한글자씩 인덱싱하면서 누적한다.
        (2) number를 갱신한다.
    3) 한자리수가 되어 while문을 빠져나오면, 3의 배수인지 확인 후 YES / NO를 출력한다.

4. 문제 해결
    1) char -> int 변환 방법 : 문자로 되어있는 char에서 '0'값을 뺀다.
       ex) char 값인 '1'을 int형으로 변환하면 아스키코드 값 49이다.
           우리는 int값 1이 필요하므로, 49-48 = 1을 만들어야 한다.
           char 값인 '0'은 아스키코드 48이다. 따라서, char '1' - char '0' = 1이 된다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine(); // 주어진 수 입력
        int count = 0; // while문 반복 횟수 기록

        while (number.length() != 1) {
            int newNumber = 0; // 누적할 변수 선언
            count++;

            // for문 돌려서 각 자릿수 누적
            for (int i = 0; i < number.length(); i++) {
                int n = number.charAt(i) - '0'; // 아스키코드 빼서 정수만들어주기
                newNumber += n;
            }
            number = String.valueOf(newNumber); // 다시 문자로 변환하여 number 값 갱신
        }
        System.out.println(count);
        System.out.println(Integer.parseInt(number) % 3 == 0 ? "YES" : "NO");

    }
}