import java.util.Scanner;

/*
    1. 문제 분석
        1) A, B, C, D, E를 받는다.
        2) 검증수를 구한다.
        3) 검증수를 출력한다.

    2. 의사 결정
        1) A~E는 0부터 9 사이의 수이다. nextInt()를 통해 받는다.
        2) 검증수는 몫이 아닌 나머지!
        3) 전체 숫자를 출력하는 것이 아니라 검증수를 출력하는 것!


 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        int E = scanner.nextInt();

        int F = (A*A + B*B + C*C + D*D + E*E) % 10;

        System.out.println(F);

    }
}
