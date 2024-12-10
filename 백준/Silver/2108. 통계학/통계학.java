import java.io.*;
import java.util.*;

/*
1. 문제 분석
    1) N개의 수가 주어지면,
    첫째줄에 산술평균 (N개의 수의 합을 N으로 나눈 값, 소수점 이하 첫째자리에서 반올림)
    둘째줄에 중앙값 (오름차순으로 나열했을 때 중앙에 위치하는 값)
    셋째줄에 최빈값 (가장 많이 나타나는 값, 여러개일 경우 두번째로 작은 최빈값)
    넷째 줄에 범위 (최댓값 - 최솟값)
    를 출력한다.

2. 제약 조건
    0 <= 숫자 개수 N <= 500,000
    N(숫자의 개수)은 홀수
    |주어지는 숫자 X| <= 4000

3. 의사결정
    1) 첫줄에서 N을 받고, 크기가 N인 트리맵을 만들고, N만큼 for문을 돌려서 각 X를 받는다.
        * 입력받을때 같이 해야 할 것
         - 산술평균때 사용하기 위해, 입력받을때 미리 누적해둔다.
         - 키 오름차순 정렬
    2) 4가지를 출력하는 메서드를 각각 만들고 메인에서 호출한다.
    3) 산술평균 -> 배열에 있는 값을 모두 누적한 값을 N으로 나눠서 리턴
    4) 중앙값 -> 오름차순 정렬된 곳에서 중앙 인덱스 값
    5) 최빈값 -> value가 가장 높은거 출력
    6) 범위 -> 0번째 key랑 마지막 key 차이

4. 문제 해결
    1) Math.round 함수 : 소수점을 첫째자리에서 반올림.
       Math.round(number * 100) / 100.0; => 둘째자리까지 반올림. 1000으로 쓰면 셋째자리까지 반올림
    2) 최빈값 확인할 때 순회 -> treeMap.entrySet()으로 키-값 쌍을 다 돌면서 확인한다.
    3) 자꾸 2%에서 틀림. 단순히 keyList.get(treeMap.size() / 2)라고 적으면 안된다.
       => 이유 : 같은 숫자를 여러번 입력받았을 경우에도 key는 하나만 들어가기 때문에 treemap.size()는 입력받은 전체 개수와 다르다!
 */

public class Main {

    static int N, total;
    static TreeMap<Integer, Integer> treeMap;
    static List<Integer> keyList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자의 개수
        N = Integer.parseInt(br.readLine());

        total = 0;

        // 저장할 트리맵 선언(오름차순 정렬)
        treeMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine()); // 받아서
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1); // 트리맵에 저장
            total += num; // 누적
        }

        // 키 리스트
        keyList = new ArrayList<>(treeMap.keySet());

        // 호출
        sb.append(call1()).append("\n");
        sb.append(call2()).append("\n");
        sb.append(call3()).append("\n");
        sb.append(call4()).append("\n");

        // 출력
        System.out.println(sb);
    }



    // 1. 산술평균
    private static int call1() {

        double result = (double) total / N; // 평균 구하고
        return (int) Math.round(result); // 첫째자리 반올림하고 int로 출력
    }

    // 2. 중앙값
    private static int call2() {

        int count = 0;
        int mid = (N + 1) / 2; // N은 항상 홀수니까 나누기하면 소수가 됨 -> 그냥 +1해서 깔끔히 나눠보기
        
        // 키-값 쌍으로 돌면서
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            count += entry.getValue(); // 개수를 단순히 인덱스로 체크하면 안됨. key에 대한 개수를 합해서 구해야 진짜 입력받은 개수임
            
            if (count >= mid) { // mid에 도착하거나 지나가면 그게 딱 가운데있는 key
                return entry.getKey();
            }
        }
        return 0; // 실행안됨
    }

    // 3. 최빈값
    private static int call3() {

        // 최빈값 key들 저장할 리스트
        ArrayList<Integer> list = new ArrayList<>();

        // valueSet에서 가장 높은 value 뽑기
        int topValue = Collections.max(treeMap.values());

        // treeMap 다 돌면서 topValue와 같은 value를 가진 key 모두 저장
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            // 최대 value랑 같은 값을 가진 key들 모두 모으기
            if (entry.getValue() == topValue) {
                list.add(entry.getKey());
            }
        }

        // 만약 최빈값이 2개 이상이면 2번째로 작은 값 출력
        if (list.size() > 1) {
            Collections.sort(list); // 정렬하고
            return list.get(1); // 2번째 값 출력
        } else { // 최빈값이 하나라면 그거 그대로 뽑기
            return list.get(0);
        }

    }

    // 4. 범위
    private static int call4() {

        int first = keyList.get(0);
        int end = keyList.get(keyList.size() - 1);

        return end - first;
    }

}
