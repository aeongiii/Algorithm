/*
1. 문제 분석
    1) 각 줄에 받은 숫자에 대해서 칸토어 집합의 근사치를 출력한다.
    - 칸토어 집합 : -를 3^N만큼 나열한 뒤, 계속 3등분해서 가운데 문자열을 공백으로 바꾼다.
    - 모든 선의 길이가 1이 되면 멈춘 뒤 출력한다.

2. 제약 조건
    1) 0 <= N <= 12

3. 의사결정
    1) 다음 줄이 있는 동안은 숫자를 받는다.
    2) 받은 숫자에 대해 3^N 길이의 - 선을 만든다.
    3) 재귀 함수를 돌린다
        - 처음 길이는 3^N이므로 , 3^N / 3 만큼이 한 덩어리이므로 3^N / 3번째부터 어디부터 어디까지가 한 덩어리인지 인덱스 구해놓기?
        - 계속해서 해당 길이에 대한 가운데 부분을 공백으로 만든다.
        - 한 덩어리의 길이가 1일때 끝.

4. 문제풀면서 수정한 부분
    1) 3의 N제곱 구하기 : Math.pow(3, N)
    2) 끝날때까지 계속 받으려면 hasNext말고도 bufferedReader로도 가능하다.
    3) 가운데 부분 공백처리 하기 전에 한 덩어리의 길이를 구해놓자!
    4) 전체 길이가 1일때가 아니라 한 덩어리의 길이가 1일때 끝내는 것이다... size랑 length 변수 의미 헷갈리지 않기

 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder result = new StringBuilder();

        while ((input = br.readLine()) != null && !input.isEmpty()) { // 있으면 계속 받음
            int N = Integer.parseInt(input);
            int size = (int) Math.pow(3, N);

            StringBuilder line = new StringBuilder();
            // 선 만들기
            for (int i = 0; i < size; i++) {
                line.append("-");
            }

            // 재귀 호출
            re(line, 0, size); // 시작 인덱스 추가!!
            result.append(line).append("\n"); // 결과 저장
        }

        System.out.print(result.toString()); // 한 번에 출력
    }

    private static void re(StringBuilder line, int start, int length) {
        // 길이가 1이면 끝
        if (length == 1) {
            return;
        }

        // 한 덩어리의 길이
        int partSize = length / 3;

        // 가운데 부분 공백으로 바꾸기
        for (int i = start + partSize; i < start + 2 * partSize; i++) {
            line.setCharAt(i, ' ');
        }

        // 좌우 부분에 대해서도 재귀 호출
        re(line, start, partSize);
        re(line, start + 2 * partSize, partSize);
    }
}