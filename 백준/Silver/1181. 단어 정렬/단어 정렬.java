import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) N개의 단어를 각 줄에 걸쳐 받은 뒤, 길이가 짧은 것 > 사전 순으로 정렬한다.
    2) 중복은 허용하지 않는다.
    3) 정렬된 단어를 출력한다.

2. 제약 조건
    1 <= N <= 20,000


3. 의사결정
    1) 정렬도 해야하는데 중복도 없어야 한다. TreeSet을 사용해보자!
    2) stream을 사용해서 정렬할거다. 내가 직접 정렬 조건을 지정한다. (요소의 길이로)
    3) 만약 길이가 같을 경우 사전 순으로 정렬한다.


4. 문제 해결

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // treeset 생성
        TreeSet<String> treeSet = new TreeSet<>((s1, s2) -> {
            // 정렬 조건 지정 1 -> 문자열 길이 오름차순
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            // 정렬 조건 지정 2 -> 길이 같을 경우 사전순
            return s1.compareTo(s2);
        });

        // 단어의 개수
        int N = Integer.parseInt(br.readLine());

        // 단어 받을때마다 바로 treeset에 저장
        for (int i = 0; i < N; i++) {
            treeSet.add(br.readLine());
        }

        // 출력
        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}
