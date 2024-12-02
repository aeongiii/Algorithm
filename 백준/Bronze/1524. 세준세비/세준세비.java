import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


/*
1. 문제 분석
    1) 하나의 테스트케이스(T)에 대하여 각각 N, M명인 병사들의 힘을 비교해 가장 약한 사람이 죽는다.
    - 가장 약한 병사가 2명 이상인 경우 : 한쪽 팀에만 있다면 그중 하나가 죽고, 양쪽팀에 있다면 세비(M)의 병사가 죽는다.

    2) 한 명의 병사만 남았다면, 어느 팀이 이겼는지 (N 또는 M)을 출력한다. 둘다 아닐 경우에는 C를 출력한다.

2. 제약 조건
    T <= 100
   1 <= N, M <= 1,000,000
   1 <= 병사들의 힘 <= 300,000,000

3. 의사결정 1 : 최소힙 2개를 사용하여 최솟값을 계속 비교
    1) 테스트케이스 T를 입력받는다.
    2) 하나의 테스트케이스에 대해, N과 M을 공백으로 구분하여 받는다.
    3) 각각 N명, M명의 병사를 공백으로 구분하여 저장한다.
       최대 백만 명의 병사를 정렬해야 하니까... 리스트보다는 최소힙을 사용하자.
    4) peek()를 활용하여 숫자를 비교한다.
        - N의 최솟값이 더 작은 경우 하나 삭제
        - M의 최솟값이 더 작은 경우 하나 삭제
        - 두 최소값이 같은 경우 M 최솟값 삭제
        - ...
    5) N의 길이가 1, M의 길이가 0이라면 N 출력
       N의 길이가 0, M의 길이가 1이라면 M 출력
       둘다 아니라면 C 출력

3. 의사결정 2 : 입력값을 배열로 받고 정렬한 뒤 인덱스를 옮겨가며 두 요소를 비교한다.
    1) 테스트케이스 T를 입력받는다.
    2) 하나의 테스트케이스에 대해, N과 M을 공백으로 구분하여 받는다.
    3) 각각 N명, M명의 병사를 한줄에 입력받을 때 각 배열로 만든다. + 정렬까지 한다.
    4) 두 병사를 비교하면서 약한 병사쪽은 다음 인덱스(다음 병사)로 넘어가서 비교한다.


4. 문제 해결
    1) 시간 초과 :: 최소힙 2개를 사용하여 최솟값을 계속 비교하는 기존 풀이 방식은 시간초과로 실패했다.
    시간복잡도를 줄이고자, 배열 안에서 정렬한 뒤, 실제로 삭제하지 않고 인덱스를 하나씩 옮겨가면서 다음 요소를 확인한다.
    2) 해시맵보다는 인덱스를 사용할 수 있도록 배열로 만든다.
    공백으로 구분하여 한 줄로 입력받기 때문에, 스트림을 사용하여 한번에 배열로 만든다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        // 테스트케이스 개수만큼 반복
        for (int i = 0; i < T; i++) {
            br.readLine(); // 줄바꿈 입력 받고 시작
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 세준이의 병사 수
            int M = Integer.parseInt(st.nextToken()); // 세비의 병사 수

            // 세준 병사
            int[] arrayS = Arrays.stream(br.readLine().split(" ")) // 공백으로 구분하여 문자열 스트림으로 변환
                    .mapToInt(Integer::parseInt) // 각 문자열을 정수 스트림으로 변환
                    .sorted() // 오름차순 정렬
                    .toArray(); // 배열로 반환!

            // 세비 병사
            int[] arrayB = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            // 인덱스
            int indexS = 0;
            int indexB = 0;

            // 배열 안을 순회
            while (indexS < N && indexB < M) {
                if (arrayS[indexS] < arrayB[indexB]) { // 세준의 병사가 더 약할 경우 다음 병사로.
                    indexS++;
                } else if (arrayS[indexS] > arrayB[indexB]) { // 세비의 병사가 더 약할 경우 다음 병사로.
                    indexB++;
                } else { // 병사의 힘이 같을 경우 세비의 병사를 다음 병사로.
                    indexB++;
                }
            }

            // 출력
            if (indexS < N && indexB == M) { // 세준이가 이겼다면
                System.out.println("S");
            } else if (indexS == N && indexB < M) {  // 세비가 이겼다면
                System.out.println("B");
            } else { // 둘다 아닐 경우
                System.out.println("C");
            }

        }
    }
}