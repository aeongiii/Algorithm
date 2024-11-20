
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 문제 분석
    1) A미터 올라가고, B미터 미끄러지는 달팽이가 있다.
    2) V미터까지 올라가려면 며칠이 걸리는가?

2. 제약 조건
    1 <= B <= A <= V <= 1,000,000,000
    A, B, V는 정수이다.

3. 의사결정
    1) A, B, V를 입력받는다.
    2) 달팽이의 위치에 +A, -B를 반복한다. (V 이상될때까지)
    3) 반복할때마다 count++ 한다.
    4) count의 값을 출력한다.
    ====> 반복문으로 계산했더니 시간 초과로 틀렸다.

4. 문제 해결
    1) 마지막 날에는 밤에 미끄러지지 않는다. 이미 낮에 정상에 도착했기 때문에.
       따라서 반대로, 전체 올라가야 할 거리에서 마지막 날에 미끄러지는 거리를 제외하면 V-B이다.
    2) 하루당 올라가는 거리는 A-B이다.
    3) 필요한 일수는    (V-B) / (A-B)   이다.
       * 만약 (V-A)/(A-B)로 구할경우 마지막날을 추가로 더해줘야 하므로 +1해서 출력해야 한다.
    4) 소수점 올림 처리를 해주어야 한다!
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int days = (int) Math.ceil((double) (V-B) / (A-B));
        System.out.println(days);


    }

}