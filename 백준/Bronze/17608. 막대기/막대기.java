import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) 각각 높이가 h인 N개의 막대기를 일렬로 세운 뒤, 가장 오른쪽(마지막)에 있는 막대기보다 높은 막대기의 개수를 구한다.
    2) 구한 수에 +1 (가장 오른쪽 막대기) 하여 출력한다.

2. 제약 조건
    2 <= N <= 100,000
    1 <= h <= 100,000

3. 의사결정
    1) BufferedReader를 사용하여 N을 입력받는다.
    2) 요소를 입력한 순서와 반대 방향으로 꺼내면서 높이를 체크하기 때문에 스택을 사용하자.
    3) 한번에 모든 줄을 입력받고, 공백으로 구분하여 각 요소를 스택에 저장한다.
    4) 마지막 요소부터 스택에서 하나씩 꺼내면서, "마지막 요소"를 기준으로 더 숫자가 큰 막대가 있으면 count++.
    5) count 변수는 기본 1로 설정한다. (마지막 막대는 기본으로 포함되니까)

4. 문제 해결
    1) EmptyStackException 문제 : last 변수에 값을 집어넣는 과정에서 이미 pop()을 한번 수행하기 때문에, 두번째 for문에서는 N-1만큼 반복해야 한다.
    2) 스택으로 해도, 배열로 해도 틀렸다고 나옴. (배열로 구현하는 경우 검사 방향을 반대로 해줘야한다.)
    3) 계속 틀리던 이유 : 가장 높은 막대기 나올때마다 last 변수 갱신해줘야 한다!! 그 뒤에 있는 막대기가 가려져서 안보일 거니까. 
    *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine()); // N 입력받기
        int[] arr = new int[N]; // 배열 선언
        int count = 1; // 기본 1인 이유는 "제일 오른쪽 막대기"는 무조건 포함이기 때문!

        // 막대기 높이를 배열에 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        int last = arr[N-1]; // 마지막 막대기 높이 저장

        // 하나씩 빼면서 개수 확인
        for (int i = N-2; i >= 0; i--) { // 이미 마지막 요소는 뺐으므로 N-1번만 반복
            if (arr[i] > last) {
                count++; // 마지막 막대기보다 높다면 카운팅 ++
                last = arr[i]; // 높이 갱신 꼭!!!
            }
        }

        System.out.println(count);

    }
}