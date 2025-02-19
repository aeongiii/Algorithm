/*
1. 문제 분석
    1) 두 단어가 같은 구성을 가지거나, 한 문자 빼고 모두 같은 경우를 비슷한 단어라고 한다.
    2) 첫번째 단어와 비슷한 단어가 모두 몇 개인지 구한다.

2. 제약 조건
    1) 1 <= 단어의 길이 <= 10
    2) 1 <= 단어의 개수 <= 100

3. 최초 의사결정
    1) N을 받고, 첫번째 단어를 받는다.
        - 첫번째 단어의 글자+개수 해시맵을 만들어둔다.
    2) N-1만큼 for문을 돌린다. 
    3) 두번째 단어부터 하나씩 받으면서
    4) (길이가 같거나 1개 이하로 차이날 경우에만 시행) 
        * 같은 구성을 갖는 경우
        - 같은 구성을 가지려면 각 글자가 같은 개수만큼 들어있어야 한다.
        - 첫번째 단어의 해시맵 길이만큼 for문 돌면서 해당 단어와 글자+개수가 동일한지 확인한다. (순서 상관없음)
        - 동일하다면 같은 구성이니까 +1하고 continue
        
        *비슷한 단어인 경우
        - 딱 한글자 차이날 경우에는 -> 문자 더하거나 빼는 경우에 해당하므로 +1하고 continue

        - keySet이 서로 같고, value가 두 곳에서 1만큼 차이날 경우에도 바뀐 경우에 해당하므로 +1하고 continue

    5) 완전히 똑같은 글자일 경우
        - equal이면 continue
           
4. 문제풀면서 수정한 부분
    1) Math.abs() : 절댓값(absolute value) 반환
    2) .tocharArray() : String을 분리해서 char[]로 변환하는 메서드
    3) 단어에서 한 글자가 변경될 경우 2개의 문자가 차이나게 된다!!!
    4) hashmap보다 빠른 방법 -> 모든 알파벳의 빈도수를 저장한다. 
    - 문자열 'A' = 65이므로 이를 기준으로 0~25까지의 인덱스로 변환한다.

 */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String firstWord = br.readLine();
        int firstLength = firstWord.length();
        int[] firstFreq = getFrequency(firstWord); // 첫번째 단어의 알파벳 빈도수 계산

        int similarCount = 0;
        
        for (int i = 0; i < N-1; i++) {
            String word = br.readLine();
            int wordLength = word.length();
            int[] wordFreq = getFrequency(word);

            if (isSimilar(firstFreq, wordFreq, firstLength, wordLength)) {
                similarCount++;
            }
        }
        System.out.println(similarCount);
    }

    private static int[] getFrequency(String word) {
        int[] freq = new int[26]; // A부터 Z까지 모두 배열로 만들기 (기본 0)
        for(char c : word.toCharArray()) {
            freq[c - 'A']++; // 해당 알파벳 인덱스에 알파벳 등장 횟수 넣기
        }
        return freq;
    }

    private static boolean isSimilar(int[] firstFreq, int[] wordFreq, int firstLength, int wordLength) {
        int changeCount = 0; // 변경된 글자의 개수
        int addOrRemoveCount = Math.abs(firstLength - wordLength); // 글자 길이 차이

        for (int i = 0; i < 26; i++) {
            changeCount += Math.abs(firstFreq[i] - wordFreq[i]); // firstWord와 word에서의 알파벳 등장 횟수를 각각 비교한 뒤, 변경된 횟수를 모두 합산
        }
        // 1. 같은 구성인 경우 (단어 길이 차이 0, 변경 횟수 0)
        if (changeCount == 0) return true;

        // 2. 한글자 추가 또는 삭제된 경우 (단어 길이 차이 1, 변경 횟수 2)
        if (addOrRemoveCount == 1 && changeCount == 1) return true;

        // 3. 한 글자만 바뀐 경우 (단어 길이 차이 0, 변경 횟수 2)
        if (addOrRemoveCount == 0 && changeCount == 2) return true;

        // 비슷한 단어가 아닌 경우
        return false;
        
    }
}
