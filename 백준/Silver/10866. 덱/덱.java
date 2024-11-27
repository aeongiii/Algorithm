
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 최적화
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.isEmpty() ? "-1" : deque.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.isEmpty() ? "-1" : deque.removeLast()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb); // 한 번에 출력
    }
}
