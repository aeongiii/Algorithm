/*

1. 문제 분석
    1) N개의 수 중에서, M개의 수가 각각 몇번 들어가 있는지 구한다.

2. 제약 조건
    1) 1 <= N, M <= 500,000
    2) -10,000,000 <= 숫자 카드에 적힌 수, 주어지는 수 <= 10,000,000

3. 최초 의사결정
    1) N을 받고, N개의 수를 받아서 treemap과 hashmap(수, 개수)에 저장한다.
    2) M을 받고, 각 M마다 treemap에 대한 이분탐색을 해서 수를 찾는다.
    3) 이분탐색으로 찾지 못하면 0을 출력, 찾으면 hashmap.get()을 해서 출력한다.

4. 문제풀면서 수정한 부분
    1) treemap은 굳이 이진탐색 안하고 getOrDefault로 찾아도 된다!

*/

import java.io.*;
import java.util.*;

public class Main {

    static TreeMap<Integer, Integer> treemap;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        treemap = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            treemap.put(num, treemap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(sc.nextLine());
        StringTokenizer st2 = new StringTokenizer(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st2.nextToken());
            sb.append(treemap.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);

    }
}