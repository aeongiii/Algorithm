import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력된 좌표의 수
        Stack<Integer> stack = new Stack<>();
        int buildingCount = 0; // 최소 건물 개수

        stack.push(0); // 스택 초기화 (기본 고도 0)

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[1]); // 현재 고도

            // 현재 고도가 스택의 최상단보다 낮으면 스택에서 제거
            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
            }

            // 현재 고도가 스택의 최상단보다 높으면 건물 추가
            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
                buildingCount++;
            }
        }

        System.out.println(buildingCount);
    }
}
