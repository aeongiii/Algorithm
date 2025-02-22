/*
1. 문제 분석
    1) N에 포함된 숫자들을 정렬하여 30의 배수를 만들 수 있다면 그중 가장 큰 수를 출력.
    2) 30의 배수를 만들 수 없다면 -1을 출력

2. 제약 조건
    1) N은 최대 10^5개의 숫자로 구성되어 있다.
    2) N은 0으로 시작하지 않는다.

3. 최초 의사결정
    1) N을 입력받고 char[]에 넣는다.
    2) 30의 배수가 되려면 3의 배수이면서 10의 배수여야 함 
     - 모든 char를 더해서 3의 배수가 나오지 않을 경우 또는 0이 포함되지 않은 경우 -1 출력
    3) 가장 큰 30의 배수를 찾아야 한다.
    - 일단 맨 끝에 0을 위치시키면 무조건 10의 배수이므로,
    char[]에서 0하나를 먼저 빼고 나머지 수만 3의 배수가 되도록 만든다.
    4) 모든 방법으로 정렬했을 때 %3 == 0이 나오는 수를 구한다.
    5) 가장 큰 수 하나만 남긴다.
    6) 마지막에 0하나 더 붙여서 출력한다.


4. 문제풀면서 수정한 부분
    1) Charactor.toString(c) : char -> String 변경
    2) 아니 어차피 3의 배수이고 30의 배수면 그냥 내림차순 정렬하면 제일 큰 수잖아?????
    - 이렇게 하면 어차피 0도 제일 끝에 정렬되니까 삭제할 필요가 없다

 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        ArrayList<Character> charList = new ArrayList<>();
        int hap = 0;
        boolean containZero = false;
        for (int i = 0; i < N.length(); i++) {
            char n = N.charAt(i);
            charList.add(n);
            hap += Integer.parseInt(Character.toString(n));
            if (n == '0') {
                containZero = true;
            }
        }

        // 30의 배수가 아닌 경우
        if(hap % 3 != 0 || !containZero) {
            System.out.println(-1);
            return;
        } 

        // 30의 배수인 경우 내림차순 정렬해서 출력
        charList.sort(Comparator.reverseOrder());
        // String charListToString = String.valueOf(charList);
        StringBuilder sb = new StringBuilder();
        for(char c : charList) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}