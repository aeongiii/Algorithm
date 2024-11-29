import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) N개의 단어 중 비밀번호를 찾아서, 비밀번호의 길이와 가운데 글자를 출력한다.
    2) 비밀번호의 경우, 비밀번호를 뒤집은 글자도 입력에 포함되어있다.
    3) 정답인 경우는 두 가지다. 
        (1) 단어(las)와 뒤집은 단어(sal)가 입력값에 각각 포함된 경우
        (2) 단어(kisik)가 대칭 형태일 경우

2. 제약 조건
    2 <= N <= 100
    2 < 단어의 길이 < 14
    단어의 길이는 홀수

3. 의사결정
    1) N을 입력받는다.
    2) N만큼 for문을 돌리고, 한 줄씩 받으면서 hashmap에 [단어 : 뒤집은 단어] 로 저장할 것.
    3) 만약, 단어 = 뒤집은 단어라면 정답!
    4) 만약, value(뒤집힌 단어)중에서 현재 입력받은 단어와 같은 value가 존재한다면 정답!
    5) 3과 4 모두 해당되지 않는다면, hashmap에 저장.


4. 문제 해결
    1)

 */

//
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim()); // N 받기
        HashMap<String, String> hashmap = new HashMap<>(); // hashmap 선언

        // 단어 받기
        for(int i = 0; i < N; i++) {

            String word = br.readLine().trim(); // 단어 받기
            StringBuffer sb = new StringBuffer(word); // 단어 sb에 저장 (뒤집기 위해서)
            String word_flip = sb.reverse().toString();

            if (word.equals(word_flip)) { // 만약 단어가 대칭이라면, 정답이기 때문에 바로 종료
                char middle = word.charAt(word.length()/2);
                System.out.println(word.length() + " " + middle);
                break;
            }

            // 만약 이미 저장된 hashmap의 value 중에서 같은 글자가 있다면, 정답이기 때문에 바로 종료
            if (hashmap.containsValue(word)) {
                char middle = word.charAt(word.length()/2);
                System.out.println(word.length() + " " + middle);
                break;
            }

            // 그렇지 않다면 해시맵에 저장
            hashmap.put(word, word_flip);

        }

    }
}