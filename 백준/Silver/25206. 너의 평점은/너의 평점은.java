/*

1. 문제 분석
    1) 20줄에 걸쳐 과목명 + 학점 + 등급이 공백으로 구분되어 주어질 때,
    전공과목별 학점 X 과목평점의 합을 학점의 총합으로 나눈 값을 구한다.

2. 제약 조건
    1) 1 <= 과목명의 길이 <= 50
    2) 

3. 최초 의사결정
    0) 등급에 따른 과목평점을 해시맵에 저장해둔다.
    1) for문을 20번 돌려서 각 과목명+학점+등급을 받는다.
    2) 등급을 확인하여 과목평점을 구한다.
        - P인 과목은 continue
        - F인 과목은 계산함
    3) 학점*과목평점의 총합 & 학점의 총합을 구한다.
    4) 20줄이 모두 끝났다면 학점*과목평점의 총합을 / 학점의 총합으로 나눈다.
    5) 

4. 문제풀면서 수정한 부분
    1) int가 아닌 double로 받아야 한다.

*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        double totalHakjeom = 0;
        double totalPyeongjeom = 0;
        
        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subjectName = st.nextToken();
            double hakjeom = Double.parseDouble(st.nextToken());
            String deunggeup = st.nextToken();

            if (deunggeup.equals("P")) continue;

            totalPyeongjeom += hakjeom * map.get(deunggeup);
            totalHakjeom += hakjeom;
        }

        System.out.printf("%.6f", totalPyeongjeom / totalHakjeom);
        
    }
}