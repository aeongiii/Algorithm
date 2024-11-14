import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
1. 문제 분석
    1) T개의 문자열 S를 각각 입력받아서,
    2) isPalindrome 함수의 반환값 + recursion 함수의 호출 횟수를 한줄에 공백으로 구분하여 출력

2. 제약 조건
   1 <= T <= 1000
   1 <= |S| <= 1000

3. 의사결정
    1) T를 입력받는다.
    2) T만큼 for문을 돌린다.
    3) S를 입력받을때마다 isPalindrome 함수를 호출한다.
    4) isPalindrome 함수는 recursion 함수를 호출한다.
    5) recursion 함수는 (1) l이 r보다 크거나 같다면 1을 반환 / (2) 양쪽 값이 다르다면 0 반환 / (3) l이 r보다 작다면 다시 재귀함수 호출

4. 문제 해결
    
 */

public class Main {

    static int output1 = 0;  // isPalindrome 반환값
    static int output2 = 0;  // recursion 호출 횟수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // T 받기

        for (int i = 0; i < T; i++) { // T만큼 문자열 S 받아서 검사
            String s = br.readLine();
            output1 = isPalindrome(s); // 반환값
            System.out.println(output1 + " " + output2); // 반환값 + 호출횟수

            output1 = 0; // 초기화
            output2 = 0;
        }

    }

    // 재귀함수
    public static int recursion(String s, int l, int r) {
        output2++; // 재귀함수 호출 횟수 카운팅
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    // 팰린드롬인가?
    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }

}