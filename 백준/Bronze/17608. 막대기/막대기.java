import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim()); // N 입력
        int[] arr = new int[N]; // 배열 선언
        int count = 1; // 마지막 막대기는 무조건 포함

        // 막대기 높이 배열 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        int last = arr[N - 1]; // 마지막 막대기 높이 기준

        // 오른쪽에서 왼쪽으로 순회
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] > last) { // 현재 막대기가 기준보다 높은 경우
                count++;
                last = arr[i]; // 새로운 기준 갱신
            }
        }

        System.out.println(count); // 결과 출력
    }
}