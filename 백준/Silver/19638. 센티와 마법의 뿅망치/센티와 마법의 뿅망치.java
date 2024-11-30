import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" "); // 입력

        int n = Integer.parseInt(parts[0]); // 거인의 개수
        int my_height = Integer.parseInt(parts[1]); // 센티의 키
        int numOfTry = Integer.parseInt(parts[2]); // 망치 횟수

        // 가장 큰 키를 출력해야 하기 때문에 우선순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while (n-- > 0) {

            // 거인의 키 다 받아옴
            int input = Integer.parseInt(br.readLine());
            queue.offer(input);

        }

        int cnt = 0; // 사용 횟수
        while (numOfTry > 0) {
            int taller = queue.peek();

            if (taller < my_height || taller == 1) {
                break; // 반복 필요 없으니까 탈출
            }

            // 망치 사용
            queue.offer(queue.poll() / 2);

            cnt++;
            numOfTry--; // 망치 모두 사용 시 반복문 탈출
        }

        // 출력
        if (queue.peek() >= my_height) {
            System.out.println("NO\n" + queue.peek());
        } else {
            System.out.println("YES\n" + cnt);
        }
    }
}