/*
1. 문제 분석
    1) N개의 길이를 가진 두 단어가 아래 조건을 만족하면 YES, 아니면 NO를 출력한다.
    조건 1 : 한 단어를 재배열해 다른 단어를 만들 수 있어야 한다.
    조건 2 : 두 단어의 첫 글자와 마지막 글자가 동일
    조건 3 : 모음을 제거하면 문자열이 서로 같아야 한다.

2. 제약 조건
    1) 2 <= N <= 100,000
    2) 단어는 알파벳 소문자

3. 최초 의사결정
    1) N을 입력받는다. N <= 1이라면 조건1 불충족하므로 No 출력
    2) A단어와 B단어를 입력받는다.
    3) 각 끝이 같지 않다면 조건 2 불충족하므로 No 출력
    4) 각각 모음을 제거했을때 서로 다르면 조건 3 불충족하므로 No 출력
    5) 마지막에 Yes 출력


4. 문제풀면서 수정한 부분
    1) 조건 4 : 각 철자의 등장 횟수가 같아야 한다.
 */

 import java.io.*;
 import java.util.*;

 public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 조건 1
        if (N < 2) {
            System.out.println("NO");
            return;
        }

        String A = br.readLine();
        String B = br.readLine();

        // 조건 2
        if (A.charAt(0) != (B.charAt(0)) || A.charAt(N-1) != (B.charAt(N-1))) {
            System.out.println("NO");
            return;
        }
        
        // 조건 3
        String AA = removeMoEum(A);
        String BB = removeMoEum(B);
        if (!AA.equals(BB)) {
            System.out.println("NO");
            return;
        }

        // 조건 4
        HashMap<Character, Integer> aMap = wordMap(A);
        HashMap<Character, Integer> bMap = wordMap(B);

        if (!keySetSame(aMap.keySet(), bMap.keySet())) { // key 자체가 다른 경우
            System.out.println("NO");
            return;
        }
        for(Character c : aMap.keySet()) { // 같은 key이지만 value가 다른 경우
            int valueA = aMap.get(c);
            int valueB = bMap.get(c);
            if (valueA != valueB) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES"); // 모든 조건 통과
    }

    private static String removeMoEum(String word) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c =='i' || c == 'o' || c =='u') {
                continue; // 모음이면 패스
            }
            sb.append(c); // 자음이면 sb에 붙이기
        }
        return sb.toString();
    }

    private static HashMap<Character, Integer> wordMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private static boolean keySetSame(Set<Character> s1, Set<Character> s2) {
        if(s1.size() != s2.size()) {
            return false; // key 개수가 다른 경우
        }
        for(Character c : s1) { // key 요소가 다른 경우
            if(!s2.contains(c)) return false;
        }
        return true; // 같은 경우
    }
 }

