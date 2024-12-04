import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 길이가 N인 배열 A와 B가 있다.
    2) 각 배열의 i번째 숫자를 서로 곱하고, 곱한 값을 N까지 모두 더한 값 S를 구한다.
    3) A는 재배열 가능, B는 재배열 불가
    4) S의 최솟값을 출력한다.

2. 제약 조건
   1 <= 자연수 N <= 50
   0 <= 정수 A, B 원소 <= 100

3. 의사결정
    1) N을 입력받고, 둘째 줄과 셋째 줄을 각각 입력받아서 배열에 저장한다.
    2) 원소끼리 곱셈하는건 최솟값 x 최댓값으로 짝지어야 하지만, 곱한 값끼리 누적하는 덧셈 계산은 순서없이 실행해도 된다.
       즉, B를 재배열하면 안된다고 했지만 실제 A와 B를 오름, 내림차순 정렬한 뒤 곱해서 더하면 된다.

4. 문제 해결
    1) Arrays.stream을 사용하여 배열 및 정렬하는 과정에서, Integer와 int를 구분해야 한다.
    sorted()메서드는 정수 타입으로 변경한 뒤 수행해야 하며(문자열 정렬 방지)
    Collections.reverseOrder()는 int가 아닌 Integer에서만 동작한다.

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 배열 입력받기
        String A = br.readLine();
        int[] arrA = Arrays.stream(A.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted() // 오름차순
                .toArray();
        String B = br.readLine();
        int[] arrB = Arrays.stream(B.split(" "))
                .map(Integer::parseInt) // Integer로 변환
                .sorted(Collections.reverseOrder()) // 내림차순 - Collections.reverseOrder()는 Integer에서만 가능하다
                .mapToInt(Integer::intValue) // int로 변환
                .toArray();

        // 곱셈
        int sum = 0;

        for (int i = 0; i < arrA.length; i++) {
            sum += arrA[i] * arrB[i];
        }

        System.out.println(sum);

        }
    }
