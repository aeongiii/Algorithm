import java.util.*;
import java.io.*;


/*
1. 문제 분석
    1) 깊이가 K인 완전이진트리가 있다.
    2) 첫째 줄에 K(깊이)가 주어지고, 둘째 줄에 중위순회한 순서가 주어질 때,
    3) 빌딩의 순서를 레벨 순회한 값을 출력한다. (레벨별로 개행처리)

2. 제약 조건
   1 <= K <= 10

3. 의사결정
    1) 첫째 줄에서 K를 입력받고, 두번째 줄에서 중위순회한 값을 입력받는다.
    2) 중위순회한 값에서 가장 가운데 있는 값 = 루트노드 (깊이 1)
        * 왼쪽부터 채우기 때문에 만약 짝수라면 가운데 요소 중 오른쪽 노드가 루트 노드
    3) 루트노드를 기준으로 앞쪽은 왼쪽노드들, 뒷쪽은 오른쪽 노드들이다.
    4) 각 노드들을 깊이를 기준으로 구분해서 list에 넣는다.
    => 2~4를 반복한다(재귀)
    5) 마지막에 순서대로 출력한다.

4. 문제 해결
    1) 노드가 짝수라면(리프 노드가 하나뿐이라면)?
    2) 재귀호출 할 때마다 preorder값을 새로 만들어주는게 아니라, 인덱스만 조정해주면 쉽게 바꿀 수 있었다...
    3) 재귀호출 할 때 깊이++ 추가해주기
    4) 인덱스랑 순서랑 둘다 양의 정수라서.. 헷갈려서 고생했다
    5) 재귀호출할때 조건을 잘못 지정했다. 왼쪽 재귀는 start 기준으로, 오른쪽 재귀는 end 기준으로 설정해야 한다.
    6) 마지막 출력할 떄, 깊이에 따라 \n으로 구분해야 한다.
    7) 첫 재귀호출 할 때 preorder.length - 1로 호출해야, 제일 오른쪽 리프노드 탐색 시 범위를 넘지 않는다.

 */

public class Main {

    static String[] preorder;
    static ArrayList<List<String>> list;
    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 깊이
        K = Integer.parseInt(br.readLine());

        // 중위순회한 값
        preorder = br.readLine().split(" ");

        // list안에 K개의 리스트 넣어서 초기화
        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }

        // 재귀호출
        check(0, preorder.length - 1, 0);

        // 이중리스트에 있는 값 출력
        for (int i = 0; i < K; i++) {
            for (String s : list.get(i)) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static void check(int start, int end, int depth) {

        // 가운데 있는 부모 노드 찾기
        int middle = (start + end) / 2;

        // 이중리스트의 [depth]번째 깊이에 루트 노드 저장 (depth : 0부터 시작)
        List<String> innerList = list.get(depth);
        String root = preorder[middle];
        innerList.add(root);

        // 리프 노드일 경우 종료 (더이상 재귀 실행하지 않아도 됨)
        if (start > end) { // start == end까지만 탐색해야 한다. >가 되면 탐색 불가, 종료해줘야 함
            return;
        }

        // 넘지 않는 한에서
        if (start <= middle - 1) { // root가 [3]일 때, 왼쪽 트리는 [0]~[2]이므로 start = 0이고 end는 2(middle - 1)이 되어야 한다.
                                   // 이때 시작 인덱스(start)보다 마지막 인덱스(middle-1)가 더 커야 제대로 수행된다.
            // 왼쪽 노드들 기준 재귀 호출 (깊이++)
            check(start, middle - 1, depth + 1);
        }

        // 넘지 않는 한에서
        if (middle + 1 <= end) { // root가 [3]일 때, 오른쪽 트리는 [4]~[6]이므로 start = 4 (middle + 1)이고 end는 6이 되어야 한다.
                                 // 이때 끝 인덱스(end)보다 시작 인덱스(middle+1)가 더 커야 제대로 수행된다.
            // 오른쪽 노드들 기준 재귀 호출 (깊이++)
            check(middle + 1, end, depth + 1);
        }

    }
}