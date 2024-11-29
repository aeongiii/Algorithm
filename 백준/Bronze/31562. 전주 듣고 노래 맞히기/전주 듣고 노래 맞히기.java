import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) 정환이가 알고 있는 노래는 N개이다. 2번째 줄부터 N+1번째 줄까지 알고있는 노래의 글자수 T + 제목 + 음 7개가 주어진다.
    2) 정환이가 맞혀야 할 노래는 M개이다. N+2번째 줄부터 맞혀야 할 노래의 음 3개가 주어진다.
    3) 이미 알고있는 노래라면 "노래 제목"을 출력한다.
    4) 음이 동일한 노래가 두개 이상이라면 "?"를 출력한다.
    5) 음이 동일한 노래가 없다면 "!"를 출력한다.

2. 제약 조건
    1 <= N <= 1000
    1 <= M <= 1000
    1 <= T <= 30
    입력으로 주어지는 모든 수는 정수이다.

3. 의사결정
    1) N과 M을 입력받는다.
    2) N만큼 for문
        (1) 글자수 T + 노래제목 + 음 7개 받는다.
        (2) 음 7개 중 앞쪽 3개만 남긴다.
        (3) hashmap 만들고 음 3개를 key에, 노래제목을 value에 리스트로 넣는다.
    3) M만큼 for문
        (1) 음 3개 받는다. (중간 공백 포함)
        (2) hashmap.keyset 중에서 음 3개랑 같은게 있다면 모두 뽑아낸다.
        (3) 결과에 따라 노래 제목, ?, ! 중 적절한 것을 출력한다.


4. 문제 해결
    1) 기본 hashmap을 만들고 key에 음 3개를 넣었더니, key가 중복될 경우 value가 덮어씌워지는 문제가 있었다.
       hashmap을 <String, List<String>>으로 선언하여 value값에 제목이 여러 개 들어갈 수 있도록 변경했다.
       -> 이렇게 바꾸면 카운팅도 필요 없다!
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N 받기
        int M = Integer.parseInt(st.nextToken()); // M 받기
        HashMap<String, List<String>> hashmap = new HashMap<>(); // 해시맵 선언 [음 3개 : 제목 리스트]

        // N개의 노래 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한줄 받기
            String[] strArr = line.split(" ", 3);

            String title = strArr[1]; // 노래 제목
            String melody3 = strArr[2].substring(0,5); // "C C G G A A G" 중에서 "C C G"만 잘라서 저장

            if (!hashmap.containsKey(melody3)) hashmap.put(melody3, new ArrayList<>()); // 해당 리스트가 아직 없을 경우, [음 3개 : 리스트] 저장
            hashmap.get(melody3).add(title); // 리스트에 제목 추가
        }

        // M개의 문제 맞히기
        for (int j = 0; j < M; j++) {
            String line = br.readLine(); // 한줄 받기

            if (!hashmap.containsKey(line)) { // 일치하는 제목이 없을 경우 ! 출력
                System.out.println("!");
            } else {
                List<String> titleList = hashmap.get(line); // 해당 음에 대한 노래 제목 리스트 가져오기
                if (titleList.size() == 1) System.out.println(titleList.get(0)); // 1개뿐이라면 제목 출력
                else System.out.println("?"); // 2개 이상이라면 ? 출력
            }
        }

    }
}