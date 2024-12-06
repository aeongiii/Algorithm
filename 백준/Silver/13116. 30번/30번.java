import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findCommonAncestor(a, b) * 10).append("\n");
        }

        System.out.print(sb);
    }

    static int findCommonAncestor(int a, int b) {
        while (a != b) {
            if (a > b) a /= 2;
            else b /= 2;
        }
        return a; // 공통 조상 반환
    }
}
