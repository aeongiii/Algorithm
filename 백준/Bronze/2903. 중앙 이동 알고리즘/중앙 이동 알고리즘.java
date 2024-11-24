import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dot = 2;
        int vol = 1;
        for(int i=0; i<n; i++){
            dot += vol;
            vol*=2;
        }
        System.out.println((dot) * (dot));
    }
}