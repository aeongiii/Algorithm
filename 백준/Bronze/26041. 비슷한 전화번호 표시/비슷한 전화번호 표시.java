import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 문제 분석
    1) 문자열 A와 전화번호 B가 주어진다.
    2) 전화번호 B의 접두사에 대해 문자열 A에 몇 개 포홤되어있는지 센다.
    3) 단, 접두사와 완전히 똑같은 경우는 제외한다.

2. 제약 조건
    1 ≤ n ≤ 100,000
    2 ≤ 문자열 A 길이 ≤ 1,000,000
    2 ≤ 전화번호 길이 ≤ 10
    전화번호는 문자 ‘1’ ~ 문자 ‘9’로 이루어진 문자열이다

3. 의사결정
    1) 문자열 A를 입력받고, 공백으로 구분하여 String[]에 저장한다.
    2) 전화번호 B를 입력받고, 가능한 접두사에 대해 for문을 돌린다. 비교를 위해 문자열로 받는다.
    3) String[]을 순회하면서 해당 접두사로 시작하는 요소를 센다.
    4) 단, 접두사와 완전히 똑같은 경우는 제외한다.

4. 문제 해결
    1) 접두사인지 확인하는 방법에 대해 고민하다가 startsWith() 함수를 알게 되었다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        
        String[] str = A.split(" "); // 문자열 배열 str
        String B = br.readLine(); // 전화번호 B
        int count = 0; // 카운팅 준비
        
        for (String s : str) { // 각 문자열에 대하여
            if (s.equals(B)) continue; // 완전히 같을 경우 탈출
            if (s.startsWith(B)) count++;  // 접두사로 사용할 경우 카운팅
        }
        System.out.println(count);
    }
}