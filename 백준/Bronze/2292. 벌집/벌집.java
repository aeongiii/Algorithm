import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        int room = 1;
        int findroom = 2;

        if(n == 1) {
            System.out.print(room);
        }else{
            while(findroom <= n) {
                findroom = findroom + (6 * room);
                room++;
            }
            System.out.print(room);
        }
    }
}