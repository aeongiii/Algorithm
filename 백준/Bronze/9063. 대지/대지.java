import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int minX = 10001;
        int minY = 10001;
        int maxX = -10001;
        int maxY = -10001;
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x < minX) minX = x;
            if(x > maxX) maxX = x;

            if(y < minY) minY = y;
            if(y > maxY) maxY = y;
        }
        System.out.println((maxY-minY)*(maxX-minX));

        br.close();
    }
}