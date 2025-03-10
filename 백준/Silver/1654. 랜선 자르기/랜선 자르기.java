import java.io.*;
import java.util.*;

public class Main {
    static int[] lines;
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new int[K];
        int maxLine = 0;
        
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            maxLine = Math.max(maxLine, lines[i]);
        }

        long start = 1, end = maxLine, result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            int count = countLanCables(mid);

            if (count >= N) { 
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static int countLanCables(long length) {
        int count = 0;
        for (int line : lines) {
            count += line / length;
        }
        return count;
    }
}
