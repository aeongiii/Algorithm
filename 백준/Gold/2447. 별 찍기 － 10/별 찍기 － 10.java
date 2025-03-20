/*

1. 문제 분석
    1) 재귀적인 패턴으로 별을 찍는다. N이 3의 제곱일 때, 크기 N의 패턴은 N*N 정사각형이다.
    2) N=3일 경우 가운데 공백에 있고 나머지에 별이 하나씩 있음
    3) N > 3 일 경우 N/3*N/3의 가운데 정사각형을 제외하고, N/3이 나머지를 둘러싼 형태
    4) N이 주어질 때, 별을 출력한다.

2. 제약 조건
    1) N은 3의 거듭제곱이며, 1 <= 거듭제곱수 <= 8이다.

3. 최초 의사결정
    1) N을 받는다.
    2) [N][N]크기의 이중 배열을 만든다.
    3) 별찍기 함수를 호출한다. (x, y, N)
        - (N==3)이라면 
            - 기본 별을 찍고 리턴한다.

        - (N!=3)이라면 
            - N을 3등분하고, 가로세로 이중for문을 만들어서 가운데를 제외하고는 모두 재귀호출
            - for(0), for(0)일 경우는 func(0, 8, 0, 8)
            - for(0), for(1)일 경우는 func(9, 17, 0, 8)
            - for(1), for(0)일 경우는 func(9, 17, 0, 8)
            - for(1), for(1)일 경우는 가운데니까 pass
            - for(i), for(j)일 경우는 func(x+(N/3)*i)
    4) 별찍기가 완료되면 sb에 합쳐서 출력한다. *이 없는 부분은 " "로 이어붙인다.

4. 문제풀면서 수정한 부분
    1) sb에 담아서 한번에 출력한다.
    2) 처음에 char배열을 ' '로 초기화하면 편하다.
    3) 시작점이 어디든 n==3이라면 같은 규칙으로 별을 찍을 수 있도록 하려면 arr[x+i][y+j]를 사용한다.

*/

import java.io.*;
import java.util.*;

public class Main{

    static char[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }

        star(0, 0, N);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void star(int x, int y, int n) {
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == 1 && j == 1) {
                        arr[x+i][y+j] = ' ';
                    } else {
                        arr[x+i][y+j] = '*';
                    }
                }
            }
            return;
        }
        
        int size = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                star(x + i * size, y + j * size, size);
            }
        }
    }
}