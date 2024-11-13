import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 문제 분석
    1) N과 M을 입력받는다.
    2) 첫행부터 N행까지 입력받는다.
    3) 각 행의 내용을 좌우로 뒤집는다. (0번째 문자 <-> M번째 문자)
    4) 첫행부터 N행까지 출력한다.

2. 제약 조건
   0<=N
   M<=0

4. 의사결정
    1) N과 M은 정수이므로 nextInt()로 받는다.
    2) 각 행을 입력받아 StringBuilder에 저장한다.
    3) 각 행을 reverse하고 바로 출력한다. (배열을 사용하지 않기 위해)
    4) StringBuilder를 초기화한다.

    * 행별로 작업을 수행하려면 for문을 사용
    * reverse를 사용하려면 StringBuilder를 사용해야 한다..

5. 문제 해결
    1) "출력 형식이 잘못되었습니다"  : 빈 줄로 인해 출력 결과가 잘못 된 것 같아서, nextInt() 한 뒤 nextLine()으로 개행처리 해줌.
    2) 런타임에러(NoSuchElement) : N 또는 M이 0인 테스트케이스 때문에 발생했다. 따라서, 0인 경우를 if문으로 처리해주거나, Scanner 대신 BufferdReader를 사용해야 한다.
        * 테스트케이스에서 N 또는 M이 0인 경우, nextLine()을 통해 받을 행이 없으므로
          Scanner를 사용하면 NoSuchElementException을 반환한다.
          반면 bufferedReader를 사용하면 받아올 행이 없는 경우에 Null을 발생시키므로 에러를 발생시키지 않는다.


=> 익숙한 Scanner와 StringBuilder를 사용하여 N,M=0인 경우를 처리하기보다,
    속도가 더 빠른 BufferedReader와 StringTokenizer를 사용해보자.

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // br로 첫 줄 받아서 st에 저장(N과 M을 공백없이 저장)

        // N, M 입력받기
        int N = Integer.parseInt(st.nextToken()); // 받은 첫줄을 N과 M으로 각각 나눔
        int M = Integer.parseInt(st.nextToken());


        // 각 행을 입력받고, 뒤집어서, 출력한다.
        for (int i = 0; i < N; i++) {

            char[] arr = br.readLine().toCharArray(); // br로 한 줄씩 받아서, char 배열에 한 글자씩 넣는다.

            for(int j = M-1; j >= 0; j--) {  // 배열에 저장된 값을 역순으로 출력한다.
                System.out.print(arr[j]);

            }
            System.out.println(); // 한 줄 출력이 끝나면 줄바꿈
        }

    }
}
