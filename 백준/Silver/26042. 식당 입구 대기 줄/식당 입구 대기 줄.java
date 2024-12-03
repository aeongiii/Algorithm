import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


/*
1. 문제 분석
    1) N개의 정보가 주어진다.
    2) 각 정보는 1 a 또는 2 중 하나이며, 1 a일 경우 a라는 학생을 넣는다. 2일 경우 앞에서부터 뺀다.
    3) 줄을 서서 대기하는 학생 수가 최대가 되었던 순간들 중 가장 작은 맨 뒷번호를 출력한다.

2. 제약 조건
   1 <= N <= 100,000
   1 <= a <= n, a의 값은 모두 서로 다르다.

3. 의사결정
    1) N을 입력받고, N만큼 while을 돌린다. 큐를 선언한다.
    2) 반복문 안에서 N줄을 차례로 입력받는다. 한줄을 받을때마다 저장 + 대기인원 수(큐의 길이)를 센다.
    3) 큐의 길이가 지금까지 중 최대일 때, 맨뒷줄(방금 들어간 수)의 값을 저장한다. ===> 데크가 낫나?


4. 문제 해결
    1)

 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 받기
        int N = Integer.parseInt(br.readLine());

        // 큐
        Queue<Integer> queue = new LinkedList<>();

        int longer_queue = 0;
        int last_student = 0;
        int student = 0;

        for (int i = 0; i < N; i++) {
            // 한줄 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int category = Integer.parseInt(st.nextToken()); // 유형 1 또는 2

            // 저장
            if (category == 1) { // 1일 경우 학생까지 입력받고 저장
                student = Integer.parseInt(st.nextToken());
                queue.add(student);
            } else { // 2일 경우 하나 뽑음
                queue.poll();
            }

            // 크기 검사

            // 지금 큐 길이가 최대 길이라면, 갱신
            if (longer_queue < queue.size()) {
                longer_queue = queue.size();
                last_student = student; // 가장 최근의 student가 맨 뒤에 있으므로 이거 넣기
            }
            // 지금 큐 길이와 최대 큐 길이가 같고 + 지금의 학생 수가 더 작다면, 갱신
            else if (longer_queue == queue.size() && last_student > student) {
                last_student = student;
            }
        }

        // for문이 다 끝났다면 출력
        System.out.println(longer_queue + " " + last_student);
    }
}