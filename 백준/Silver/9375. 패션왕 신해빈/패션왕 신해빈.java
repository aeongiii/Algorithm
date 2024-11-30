import java.util.*;
import java.io.*;

/*
1. 문제 분석
    1) T개의 테스트케이스가 두번째 줄부터 각각 주어진다.
    2) 하나의 테스트케이스 안에서, 첫째 줄 n(의상의 수)이 주어지고, 둘째 줄부터 n개의 [의상 이름 + 의상 종류]가 주어진다.
    3) 의상 종류당 하나만 입을 수 있을 때, 몇개의 가짓수가 있는가?

2. 제약 조건
   T <= 100
   0 <= n <= 30

3. 의사결정
    1) 첫째줄에서 T를 받고, T만큼 테스트케이스를 반복한다. 해시맵<문자열, 문자열리스트> 선언
    2) 하나의 테스트케이스에서, 의상의 수 N을 받는다.
    3) N만큼 for문을 돌려서 의상종류를 key에, 해당 의상의 개수를 value에 넣는다.
    4) 의상을 다 받고 난 뒤, 가능한 경우를 모두 카운팅해야한다.
        - 카운팅 하는 법 : 각 종류마다 (의상개수 + 1) 만큼의 선택지가 있다. (안입을수도 있으므로) -> 다 곱한다.

4. 문제 해결
    1) 가능한 개수를 출력하면 되기 때문에 value에 의상 이름을 다 넣을 필요 없다.
    2) 카운팅하는 법을 너무 오래 고민했다...
    3) 테스트케이스마다 해시맵을 새로 초기화해야 한다.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        while (T-- > 0) {
            HashMap<String, Integer> hashmap = new HashMap<String, Integer>(); // 해시맵 선언
            int n = Integer.parseInt(br.readLine()); // 의상 개수

            for (int i = 0; i < n; i++) { // 의상 한줄씩 저장

                String[] clothes = br.readLine().split(" "); // [의상이름, 의상개수] 입력받기

                if (hashmap.containsKey(clothes[1])) { // 이미 key 있을 경우 value에만 +1해서 다시 추가
                    int value = hashmap.get(clothes[1]);
                    hashmap.put(clothes[1], value + 1);
                } else { // key 없는 경우 새로 저장하고 value는 1로 초기화
                    hashmap.put(clothes[1], 1);
                }
            }

            // 의상을 모두 저장했으니 경우의 수 출력
            int output = 1; // 곱셈할거니까 0이 아닌 1로 초기화해야한다.
            for (String key : hashmap.keySet()) { // 종류별 의상의 개수 +1 만큼 다 곱함
                output *= (hashmap.get(key) + 1);
            }
            System.out.println(output - 1); // 아무것도 안 잆는 경우 하나 빼줘야 한다.


        }
    }
}