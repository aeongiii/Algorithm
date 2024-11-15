import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 문제 분석
    1) 공백으로 구분된 세 자리 수 2개가 주어진다.
    2) 각 수를 뒤집은 뒤 큰 수를 출력한다.

2. 제약 조건
    두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.

3. 의사결정
    1) StringTokenizer로 세 자리 수 2개를 입력받는다.
    2) 각 수를 뒤집은 뒤 비교하여 큰 수를 출력한다.

4. 문제 해결
    1) String 대신 StringBuffer 또는 StringBuilder를 사용하면 문자열을 편집할 수 있다.
       StringBuffer는 멀티쓰레드에 안전하도록 설정되어있으므로,
       멀티쓰레드로 작성된 프로그램이 아닌 경우 StringBuilder를 사용하는 것이 성능 면에서 좋다.
    2) if문을 사용해 큰 수를 비교하는 것보다 Math.max를 사용하는 것이 좋다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 토큰 받아서 > StringBuilder 클래스로 변환 > reverse() > toString() > int로 변환
        int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

        // Math 라이브러리를 이용해서 큰 수 출력
        System.out.println(Math.max(A,B));

    }
}