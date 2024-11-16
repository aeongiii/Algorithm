import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 공백으로 구분된 모스 부호를 해독하여 N글자의 문자열을 출력한다.
    2) 알파벳의 경우, 반드시 대문자로 출력한다.

2. 제약 조건
    1 <= N <= 100

3. 의사결정
    1) 일단 모스부호를 알려준다. Map을 사용하여 key에 모스부호를, value에 문자를 넣는다.
    2) 첫째줄 N을 받는다.
    3) 둘째줄 모스부호를 입력받고, 공백으로 구분한 뒤, 각 토큰을 한글자씩 해독하여 출력한다.

4. 문제 해결
    1) 
 */

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");

        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");

        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");

        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");

        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");

        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");

        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put("-----", "0");

        map.put("--..--", ",");
        map.put(".-.-.-", ".");
        map.put("..--..", "?");
        map.put("---...", ":");
        map.put("-....-", "-");
        map.put(".--.-.", "@");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N 받기

        String[] mosArray = br.readLine().split(" "); // 모스부호 받기
         for (String mos : mosArray) { // 한글자씩 해독
             String value = map.get(mos);
             System.out.print(value); // 출력
         }

    }
}