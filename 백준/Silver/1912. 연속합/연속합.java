import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가장 큰 수 초기화
        int maxNum = Integer.MIN_VALUE;

        // N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 수 입력받기
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            input[i] = num;
            // 개별 수 중에서 가장 큰 수 저장해두기
            if (maxNum < num) {
                maxNum = num;
            }
        }

        if (N == 1) {
            System.out.println(input[0]);
            return;
        }

        // 계산하기
        int hap = input[0]; // 첫 번째 값으로 초기화
        int currentMax = input[0]; // 첫 번째 값으로 초기화
        
        for (int i = 1; i < N; i++) {
            hap = Math.max(input[i], hap + input[i]);
            currentMax = Math.max(currentMax, hap);
        }
        
        System.out.println(currentMax);
    }
}
