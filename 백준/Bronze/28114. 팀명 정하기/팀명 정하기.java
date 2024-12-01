import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


/*
1. 문제 분석
    1) [문제개수 + 입학연도 + 이름]으로 구성된 입력이 3번 주어진다.
    2) 3개의 입학연도를 각각 100으로 나눈 나머지를 오름차순 정렬하여 이어붙인 문자열 출력
    3) 문제 수가 많은 사람부터 내림차순 정렬하여 이름 첫 글자를 나열한 문자열 출력

2. 제약 조건
   1 <= 서로 다른 문제 개수 P <= 20000
   2010 <= 서로 다른 입학연도 <= 2099
   1 <= 서로 다른 이름 <= 5

3. 의사결정
    1) 첫번째 출력 : 연도를 저장한 뒤 정렬해서 뽑아낼거다. 오름차순으로 뽑아낼거니까 최소힙을 사용하자.
        - 각 입력에서 두번째 값을 뽑아서 뒷쪽 2글자만 최소힙에 저장한다. 10~99이므로 100으로 나눴을 때의 나머지와 같다.
        - 다시 뽑으면서 sb에 이어붙여 문자열을 만든다. + 줄바꿈

    2) 두번째 출력 : key = 문제개수, value=이름첫글자로 저장할건데, 정렬을 위해 LinkedHashmap을 쓸거다.
        - LinkedHashmap 선언 후 key = 문제개수, value = 이름 첫글자만 떼서 저장한다.
        - keyset 만들고 내림차순 정렬한다. (문제수가 많은 사람부터 나열하니까)
        - 0번째부터 key를 활용해 value를 뽑아온다.
        - sb에 이어붙여서 한번에 출력한다.



4. 문제 해결
    1)

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<String> minHeap = new PriorityQueue<>(); // 첫번째 출력에서 사용할 최소힙
        LinkedHashMap<Integer, Character> hashmap = new LinkedHashMap<>(); // 두번째 출력에서 사용할 LinkedHashmap
        StringBuilder sb = new StringBuilder(); // 출력할 내용을 저장할 sb

        for (int i = 0; i < 3; i++) { // 입력은 항상 3줄이다.

            // 한줄 받기
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int question = Integer.parseInt(st.nextToken()); // 맞힌 문제 개수
            String year = (st.nextToken()).substring(2, 4); // 입학 연도 뒷쪽 두자리만 뽑음
            char name = st.nextToken().charAt(0); // 이름 첫 글자만 뽑음

            // 저장
            minHeap.add(year);
            hashmap.put(question, name);
        }

        // 첫번째 출력 : 최소힙에서 하나씩 뽑아서 문자열로 붙인다. ex) 192021
        while (!minHeap.isEmpty()) {
            sb.append(minHeap.poll());
        }
        sb.append('\n'); // 줄바꿈

        // 두번째 출력 : key 기준 내림차순 정렬 후 value를 문자열로 붙인다.
        hashmap = hashmap.entrySet().stream()  // 키-값 쌍으로 구성된 Set으로 변환 후 stream 연산 수행
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) // key를 기준으로 내림차순 정렬
                .collect(Collectors.toMap(  // stream(순차적 처리를 위한 데이터 흐름) 상태의 데이터를 다시 LinkedHashmap으로 변환
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, // Collectors.toMap은 중복 불가하므로 만약 같은 key가 있다면 어떤걸 사용할지 명시해야 한다.
                        LinkedHashMap::new
                ));

        for (int key : hashmap.keySet()) { // 정렬한 각 key에 대해 value를 이어 붙임
            sb.append(hashmap.get(key));
        }

        System.out.println(sb); // 전체 출력
    }
}