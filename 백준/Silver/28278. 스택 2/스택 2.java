import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int count = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < count; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      if (input[0] == 1) {
        stack.push(input[1]);
      } else {
        switch (input[0]) {
          case 2:
            bw.write((stack.isEmpty() ? -1 : stack.pop()) + "\n");
            break;
          case 3:
            bw.write(stack.size() + "\n");
            break;
          case 4:
            bw.write((stack.isEmpty() ? 1 : 0) + "\n");
            break;
          case 5:
            bw.write((stack.isEmpty() ? -1 : stack.peek()) + "\n");
            break;
        }
      }
    }

    bw.flush();
    bw.close();
    br.close();

  }
}