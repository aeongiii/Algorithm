import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 문제 분석
    1) 재귀 횟수 N을 입력받는다.
    2) 기본 호출 1번 + N번 재귀함수를 호출한다.

2. 제약 조건
   1 ≤ N ≤ 50

3. 의사결정
    1) N을 입력받는다.
    2) 재귀함수를 기본 1번 + N번 호출한다.

4. 문제 해결
    1) underBar를 어디에 위치하느냐로 혼동을 겪었다. 스택이 생기고 사라질때마다 underBar가 변경되기 위해 재귀함수의 파라미터로 넣었다.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 재귀함수 호출 횟수
        int N = Integer.parseInt(br.readLine());
        String underBar = "";

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        response(N, underBar);
    }

    // 재귀함수
    public static void response(int N, String underBar) {
        System.out.println(underBar + "\"재귀함수가 뭔가요?\"");

        if (N == 0) {
            System.out.println(underBar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(underBar + "라고 답변하였지.");
            return;
        }

        System.out.println(underBar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(underBar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(underBar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        // 다음 재귀 호출을 위한 underBar 추가
        response(N - 1, underBar + "____");

        // 현재 재귀 깊이에서의 underBar로 "라고 답변하였지." 출력
        System.out.println(underBar + "라고 답변하였지.");
    }
}