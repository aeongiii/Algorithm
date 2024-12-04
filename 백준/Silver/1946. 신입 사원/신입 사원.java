import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 각 테스트케이스 T에 대하여, 지원자의 개수 N이 주어진다.
    2) 다음 줄부터 각 지원자의 서류 순위 + 면접 순위가 주어진다. (점수가 아니라 순위이므로 1이 가장 높음)
    3) A의 성적이 B의 성적에 비해 서류&면접 모두 떨어진다면 탈락.
    4) 선발할 수 있는 최대 인원 수를 구한다.

2. 제약 조건
   1 <= T <= 20
   1 <= N <= 100,000


3. 의사결정
    1) T를 받고, T만큼 반복
    2) N을 받고, N만큼 반복하면서 각 지원자의 서류 + 면접 순위를 배열로 입력받는다.
    3) 리스트에 넣고 key(서류)를 기준으로 오름차순 정렬한다.
    4) 서류는 정렬 되었으므로, 서류가 높은 애들부터 면접 순위를 비교한다.
    5) i번째의 면접 순위가 지금까지 검사한 최고 면접 순위보다 높으면 합격, 낮으면 탈락.
    6) 카운트 세서 인원수 출력한다.

4. 문제 해결
    1) 처음에 hashmap으로 했는데, 디버깅 돌렸을 때는 hashmap 자체에서 key값 기준으로 바로 정렬되어 들어가는 것처럼 보여서 혼동이 좀 있었는데,
    실제 hashmap에서는 순서가 보장되지 않는다!
    keyset을 정렬하여 사용하는 내용을 제외한 뒤 다시 실행해봤을 때 정답이 보장되지 않은 것을 보고 확실히 알 수 있었다.
    2) 순서가 없는 hashmap보다, 처음부터 리스트로 저장하는게 훨씬 효율적인 것 같다.
    3) 리스트를 오름차순할 때는 sort()를 쓰는데,
    내가 원하는 기준대로 정렬하기 위해 비교 기준으로 사용하는 Comparator 객체 생성해서 간단히 정렬했다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 지원자 수
            int N = Integer.parseInt(br.readLine());
            // 리스트 선언
            List<int[]> applicant = new ArrayList<>();
            // 카운팅 변수
            int count = 0;

            // 서류 + 면접 정보 배열로 받아서 리스트에 저장
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int testA = Integer.parseInt(st.nextToken());
                int testB = Integer.parseInt(st.nextToken());
                applicant.add(new int[]{testA, testB}); // int배열 만들어서 바로 집어넣음
            }

            // 서류정보(a[0])를 기준으로 오름차순 정렬
            // 정렬기준 : int[]배열 a를 파라미터로 할 때 0번째 값(서류)을 기준으로 오름차순 정렬
            applicant.sort(Comparator.comparingInt(a -> a[0]));
            
            // 면접 순위 비교
            int top = applicant.get(0)[1]; // 첫번째 지원자는 무조건 합격이므로 첫번째 지원자 값으로 초기화한다.
            count++; // 첫지원자 합격

            for (int i = 1; i < applicant.size(); i++) { // 0이 아니라 1부터 시작
                int[] a = applicant.get(i);
                // a지원자의 면접순위가 최고순위보다 낮으면(=순위가 더 높으면) 합격
                if (a[1] < top) {
                    count++;
                    top = a[1]; // 최고순위 갱신
                }
            }

            // 비교가 끝나면 count 출력
            System.out.println(count);
        }

    }
}