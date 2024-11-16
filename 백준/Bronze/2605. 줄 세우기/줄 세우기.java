import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) 첫째 줄에는 학생의 수 S가 주어진다.
    2) 둘째 줄에 줄을 선 차례대로 학생이 뽑은 번호가 주어진다. (pop1. pop2. pop3...)
    3) 최종적으로 줄을 선 순서를 번호로 출력한다.
    - 첫번째 학생은 무조건 0을 뽑는다.

2. 제약 조건
    학생의 수 S <= 100
    뽑는 번호는 0 또는 자연수이다.

3. 의사결정
    1) 학생 수 S를 받고, 길이가 S인 배열 pop과 리스트 line을 만든다.
       * ArrayList를 사용하면 중간 삽입 시 뒷 요소가 하나씩 밀리고, 중간에 빈 공간 없이 연속된 자료구조이므로 적절.
    2) pop : 뽑은 번호를 입력값으로 받아서 하나씩 넣는다.
    3) line : 뽑은 번호에 따라 줄을 세운다.
    4) S만큼 for문을 돌리고, i번째로 뽑은 학생을 list[length - pop[i]]번째로 넣는다.
       * 1을 뽑으면 뒤에서 1번째에, 2를 뽑으면 뒤에서 2번째에, K를 뽑으면 length-k번째에 줄을 선다.
    5) 완성된 list를 공백으로 구분하여 반환한다.

4. 문제 해결
    1) list에 들어갈 수는 i가 아니라 i+1이다. i=0부터 시작하기 때문.
    2) list에 들어갈 위치는 list.size()-1-here가 아니라 list.size()-here이다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int S = Integer.parseInt(br.readLine()); // 학생 수
        ArrayList<Integer> list = new ArrayList<>(); // 줄 세울 리스트 선언

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < S; i++) {
            int num = Integer.parseInt(st.nextToken()); // 뽑은 번호 수 하나씩 받아서
            list.add(list.size()-num, i+1); // 번호에 맞게 뒤에서부터 줄 세우기
        }

        for (int l : list) { // 출력
            System.out.printf("%d ", l);
        }
    }
}