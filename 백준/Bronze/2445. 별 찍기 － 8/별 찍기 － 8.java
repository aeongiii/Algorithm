import java.util.Scanner;

/*
1. 문제 분석
    1) 1부터 100 사이의 자연수 N을 입력받는다.
    2) 2*N-1줄까지 별을 출력한다.
    3) 별을 출력하는 규칙 : 1 ~ 2*N-1 ~ 1개의 별을 양쪽으로 출력한다.
    4) 개수를 세어가면서 규칙을 찾아봤다.
      - 출력되는 한 줄은 양쪽으로 대칭이다.
      - N번째 줄을 기준으로 위아래 대칭이다.
      - 1번째 줄부터 N번째 줄까지 :: i개의 별을 찍는다 + 2(n-1)개의 빈칸을 찍는다 + 다시 i개의 별을 찍는다.
      - N+1번째 줄부터 마지막 줄까지 :: 2N-1개의 별을 찍는다 + 2(i-N)개의 빈칸을 찍는다 + 다시 2N-1개의 별을 찍는다.

2. 제약 조건
    1 <= N <= 100

4. 의사결정 : 규칙 활용🌟
    1) i=1 부터 i=2N-1까지 i가 계속 증가하는 for문을 만든다.
    2) i가 1부터 N까지는 [i개의 별 + (N-i)개의 빈칸 + (N-i)개의 빈칸 + i개의 별]을 출력한다.
    3) i가 N+1부터 2N-1까지는 [2N-i개의 별 + (i-N)*2개의 빈칸 + (i-N)*2개의 빈칸 + 2N-i개의 별]을 출력한다.

 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();


        // N
        int N = scanner.nextInt();


        // 별 찍기
        for (int i = 1; i<=N*2-1; i++) {

            // i가 N보다 작은 경우 (별의 개수가 점점 많아짐)
            if (i <= N) {
                for (int j = 1; j <= i; j++) {
                    stringBuilder.append("*"); // i 만큼 반복하여 * 출력
                }

                for (int h = 1; h <= (N-i)*2; h++) {
                    stringBuilder.append(" "); // N-i 만큼 반복하여 빈칸 출력
                }

                for (int j = 1; j <= i; j++) {
                    stringBuilder.append("*"); // i 만큼 반복하여 * 출력
                }
            }

            // i가 N보다 작은 경우 (별의 개수가 점점 적어짐)
            else {
                for (int j = 1; j <= N*2-i; j++) {
                    stringBuilder.append("*"); // i 만큼 반복하여 * 출력
                }

                for (int h = 1; h <= (i-N)*2; h++) {
                    stringBuilder.append(" "); // N-i 만큼 반복하여 빈칸 출력
                }

                for (int j = 1; j <= N*2-i; j++) {
                    stringBuilder.append("*"); // i 만큼 반복하여 * 출력
                }
            }

            System.out.println(stringBuilder.toString()); // 한줄 출력
            stringBuilder.setLength(0); // 초기화

        }

    }
}
