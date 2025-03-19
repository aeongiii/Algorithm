/*

1. 문제 분석
    1) 길이가 N인 배열 A에 K번째 저장되는 수를 출력한다. 저장 횟수가 K보다 작으면 -1을 출력한다.

2. 제약 조건
    1) 5 <= N <= 500,000
    2) 1 <= K <= 10^8
    3) 1 <= Ai <= 10^9

3. 최초 의사결정
    1) N과 K을 받고, N크기의 배열 A를 만든다.
    2) A에 각 원소를 넣는다.
    3) main메서드에 merge_sort를 구현한다.
        - p<r이면 중간지점 q를 만들고 전반/후반부 재귀호출, 병합 메서드 호출한다.
    4) 병합 메서드를 구현한다.
        - i=p, j=q+1, t=1
        - i <= q이고 j <= r일때 i번째 값보다 j번째 값이 크거나 같으면 ---> A의 i+1번째 값을 tmp의 t+1번째에 넣는다.
        - 그렇지 않으면 A의 j+1번째 값을 tmp의 t+1번째에 넣는다.
    5) while (i <= q) 일 경우 다음값도 계속 넣음
    6) while (j <= r) 일 경우 다음 값도 계속 넣음
    7) i = p, t = 1로 바꾸고
       while (i <= r)인 동안 A[i++] = tmp[t++]

4. 문제풀면서 수정한 부분
    1) p와 r은 A안에 들어있는 실제 값이 아닌 인덱스다!

*/

import java.io.*;
import java.util.*;

public class Main {

    static int save = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] A = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st2.nextToken());
        }

        merge_sort(A, 0, N - 1, K);

        System.out.println(result);
    }

    private static void merge_sort(int[] A, int p, int r, int K) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q, K);
            merge_sort(A, q + 1, r, K);
            merge(A, p, q, r, K);
        }
    }

    private static void merge(int[] A, int p, int q, int r, int K) {
        int i = p, j = q + 1, t = 0;
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }

        while (j <= r) {
            tmp[t++] = A[j++];
        }

        i = p;
        t = 0;

        while (i <= r) {
            A[i] = tmp[t];
            save++; 

            if (save == K) { 
                result = A[i];
            }
            
            i++;
            t++;
        }
    }
}
