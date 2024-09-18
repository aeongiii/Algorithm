import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken()); //정수 A
        long B = Integer.parseInt(st.nextToken()); //정수 B

        br.close();

        if(A > B){ //A가 클 경우
            bw.write(A*B/findGCD(A, B) + "\n"); 
        }else if(A < B){ //B가 클경우
            bw.write(A*B/findGCD(B, A) + "\n");
        }else{ //A와 B가 같을 경우
            bw.write(A + "\n"); //둘이 같다면 하나만 출력하기
        }

        bw.flush();
        bw.close();
    }
    
    //최소 공배수 찾는 메서드
    static long findGCD(long A, long B){
        while(B != 0){
            long R = A%B; //나머지
            A = B; 
            B = R;
        }
        return A;
    }
}