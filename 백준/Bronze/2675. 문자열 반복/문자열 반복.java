
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 문제 분석
    1) T개의 테스트케이스가 주어진다.
    2) 각 테스트케이스는 반복 횟수 R과 문자열 S가 주어진다.
    3) S의 각 문자를 R번 반복하여 출력한다.

2. 제약 조건
     1 ≤ T ≤ 1,000
     1 ≤ S ≤ 20
     1 ≤ R ≤ 8

3. 의사결정
    1) T를 입력받고, T만큼 for문을 돌린다.
    2) R과 S를 공백으로 구분하여 입력받는다.
    3) S를 char[]로 만들지 않고 인덱스를 사용해 R번 출력한다.

4. 문제 해결
    1)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T 입력받기
        int T = Integer.parseInt(br.readLine());

        // R, S 입력받기
        for (int i = 0; i < T; i++) {

            // 한줄 입력받기
            String inputLine = br.readLine();
            // 기본적으로 띄어쓰기를 통해 나눔
            StringTokenizer st = new StringTokenizer(inputLine);

            // R과 S 추출
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            // S의 길이만큼 for문 돌면서 각 문자열을 R번 반복
            for (int j = 0; j < S.length(); j++) {
                char output = S.charAt(j);

                for (int k = 0; k < R; k++) {
                    System.out.print(output);
                }

            }

            // 개행처리
            System.out.println();

        }

    }


}