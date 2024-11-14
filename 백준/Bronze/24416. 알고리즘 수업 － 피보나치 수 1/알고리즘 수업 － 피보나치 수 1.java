import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
1. 문제 분석
    1) 5에서 40 사이의 N이 주어진다.
    2) 코드 1과 코드 2를 각각 실행시키고, 각각 횟수를 카운트한다.
    3) 횟수를 출력한다.

2. 제약 조건
   5 <= n <= 40

3. 의사결정
    1) bufferedReader를 사용해 N을 받는다.
    2) 재귀호출 / 동적 프로그래밍 클래스를 각각 구현한다.
    3) 각 클래스 내에서 #코드1, #코드2가 실행되는 횟수를 세고 출력한다.

5. 문제 해결
    1) fib_count, fibonacci_count를 메인 클래스 안에다 선언했더니 자꾸 꼬였다. 전역변수로 설정하여 해결했다.
    2) fib_count가 다르게 출력되는 문제 : fib_count++;의 위치를 fib클래스 if문 안으로 옮겨서 n<=2일때도 카운팅되도록 수정했다.
 */

public class Main {

    static int fib_count = 0;  // 재귀함수 호출 횟수
    static int fibonacci_count = 0;  // 동적 프로그래밍 호출 횟수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 받기

        fib(N); // 재귀호출 수행
        fibonacci(N); // 동적 프로그래밍 수행

        System.out.println(fib_count + " " + fibonacci_count);

    }

    public static int fib(int n) { // 재귀호출 수행
        if (n <= 2) {
            fib_count++; // #코드1 부분 실행횟수 카운팅
            return 1;
        }
        return (fib(n-1) + fib(n-2));
    }

    public static int fibonacci(int n) { // 동적 프로그래밍 수행
        int[] f = new int[n+1];  // 정수 배열 f 선언
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) { // f[3] 이상인 경우
            f[i] = f[i-1] + f[i-2];
            fibonacci_count++; // #코드2 부분 실행횟수 카운팅
        }
        return f[n];
    }
}