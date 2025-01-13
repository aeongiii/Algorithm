import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = N+1;

        for(int i = M; i <= N; i++){
            int check = 0;

            for(int j = 1; j<=i; j++){
                if(i%j == 0){
                    check++;
                }
            }
            if(check == 2){
                sum+=i;
                if(min > i) min = i;
            }
        }

        if(sum == 0) System.out.print(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }

        br.close();
    }
}