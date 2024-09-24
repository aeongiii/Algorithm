import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet enterMember = new HashSet();

        int N = Integer.parseInt(br.readLine());
        int count = 0; 

        for(int i = 0; i < N; i++){
            String chat = br.readLine(); 

            if(chat.equals("ENTER")){ 
                count += enterMember.size(); 
                enterMember = new HashSet();

            }else{ 
                enterMember.add(chat);
            }
        }
        count += enterMember.size();

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}