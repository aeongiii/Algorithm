import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 문제 분석
    1) 영어 대소문자 + 공백으로 이루어진 문자열이 주어진다.
    2) 단어는 공백으로 구분된다.
    3) 단어의 개수를 세서 출력한다.
    4) 문자열의 처음과 끝에 공백이 들어갈 수 있다.

2. 제약 조건
    문자열의 길이 <= 1,000,000

3. 의사결정
    1) 문자열 S를 입력받는다.
    2) StringTokenizer를 사용해 공백 기준으로 분리한다.
    4) 토큰 길이를 출력한다.

4. 문제 해결
    1) countTokens() : StringTokenizer가 가지고 있는 토큰의 개수 반환
    2) split()은 무조건 하나 이상의 배열을 출력하기 때문에 문자열에 공백만 있을 경우 1을 반환하지만
       StringTokenizer의 경우 0을 반환하기 때문에 더 적절하다.
 */


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new java.util.StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine()).countTokens());
    }
}