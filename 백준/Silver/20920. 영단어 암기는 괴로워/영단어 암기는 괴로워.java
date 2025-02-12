/*
1. 문제 분석
    1) N개의 단어들 중 길이가 M 이상인 단어를 골라 우선순위에 맞게 정렬하여 출력한다.
    우선순위 1. 자주 나오는 단어는 앞에 배치
    2. 단어의 길이가 길수록 앞에 배치
    3. 사전 순으로 앞에 있는 단어일수록 앞에 배치

2. 제약 조건
    1) 1 <= N <= 100000
    2) 1 <= M <= 10
    3) 1 <= 단어 길이 <= 10

3. 의사결정
    1) N과 M을 입력받는다.
    2) N줄을 입력받으면서 해시맵에 넣는다. key = 단어, value = 단어가 등장한 횟수(기본 1)
    - M보다 길이가 작으면 넣지 않는다.
    3) 해시맵 사용하자.
    4) 있는 단어가 또 나오면 value++
    5) 다 받았으면 자주 나오는 단어를 앞에 배치한다. (value 기준 정렬)
    6) 단어 길이가 긴 것부터 앞에 배치한다. (키 길이 기준 정렬)
    7) 알파벳 사전 순으로 정리한다. (기본 정렬)

           
4. 문제풀면서 수정한 부분
    1) map.put(key,value) : key가 없으면 새로 만들고 있으면 value값만 변경한다.
    - map.put(word, map.getOrDefault(word, 0) + 1)로 간결하게 만들 수 있다.
    2) 입력 순서를 유지하는건 링크드 해시맵인데, 어차피 나중에 리스트로 변환 후 정렬할거라 그냥 해시맵 사용.
    3) map.entry를 사용하면 Map의 모든 키+값 쌍을 Set<Map.Entry<K,V>>로 반환한다. 하나만 묶는게 아니라 전체를 묶은 것.
    * Map.Entry<K,V> : 하나의 키+값 쌍. "apple" = 3
    * Set<Map.Entry<K, V>> : 모든 키+값 쌍을 포함한 Set. [apple=3, banana=5, cherry=2]
    * map.entrySet() : Map 전체의 키+값 쌍을 Set<Map.Entry<K, V>>형태로 반환하는 것.

 */

 import java.io.*;
 import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<String, Integer>(); 

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 다 넣었다면 map을 entrySet()을 사용하여 set으로 변경한 뒤, 정렬을 위해 List로 변환한다.
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // 정렬
        Collections.sort(list, (o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue(); // 자주 나오는 단어(빈도수) 내림차순
            }
            if (o1.getKey().length() != o2.getKey().length()) {
                return o2.getKey().length() - o1.getKey().length(); // 길이 내림차순
            }
            return o1.getKey().compareTo(o2.getKey()); // 사전순 오름차순
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);


    }
}