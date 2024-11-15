import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 파일의 개수 N이 주어진다.
    2) 둘째 줄부터 파일의 이름(소문자+점)이 주어진다.
    3) 확장자를 기준으로 분류하고, 확장자가 여러개인 경우 확장자 이름의 사전순으로 (확장자 이름 + 개수)를 출력한다.

2. 제약 조건
    1 <= N <= 50000
    3 <= 각 파일 이름의 길이 <= 100
    점은 한 번 등장하며, 파일 이름의 처음 또는 마지막에 오지 않는다.

3. 의사결정
    1) N을 입력받고, N만큼 for문을 돌린다.
    2) hashMap을 만들어서 key에는 확장자를, value에는 여러개의 파일명을 넣어준 뒤
    3) key를 사전순으로 정렬하고
    4) key값 + value개수 출력한다.

4. 문제 해결
    1) hashmap을 key기준으로 오름차순 정렬할 경우 Collection.sort(), 내림차순 정렬할 경우 Collection.reverse() 메소드를 사용한다.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<String>> hash = new HashMap<>();

        // N 받기
        int N = Integer.parseInt(br.readLine());

        // for문
        for (int i = 0; i < N; i++) {
            // .을 기준으로 파일명과 확장자로 구분
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String name = st.nextToken();
            String type = st.nextToken();

            // 만약 key에 해당 type가 없는 경우 type 먼저 새로 만들기
            if (!hash.containsKey(type)) {
                hash.put(type, new ArrayList<>());
            }
            // 해당 type에 value 추가
            hash.get(type).add(name);

        }

        // hashmap을 key 기준으로 정렬
        List<String> keySet = new ArrayList<>(hash.keySet());
        Collections.sort(keySet);

        // 정렬된 keySet에 따라 [확장자명 + 파일개수] 출력
        for(String key : keySet) {
            System.out.print(key + " " + hash.get(key).size());
            System.out.println();
        }


    }
}