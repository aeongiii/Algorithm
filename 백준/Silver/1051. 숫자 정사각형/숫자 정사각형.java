import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static final int MIN_SIZE = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        String[] rectangularArr = new String[N];
        for(int i=0; i<N; i++){
            rectangularArr[i] = reader.readLine();
        }
        int size = MIN_SIZE;
        for(int top=0; top<N-1; top++){
            for(int left=0; left<M; left++){
                char value =rectangularArr[top].charAt(left);
                for(int right=M-1; right>left; right--){
                    if(value != rectangularArr[top].charAt(right)) continue;
                    int down = top + right - left;
                    if(down<N && isSameValue(rectangularArr[down].charAt(left), rectangularArr[down].charAt(right), value)){
                        size = Math.max(size, (down-top+1)*(right-left+1));
                        break;
                    }
                }
            }
        }
        System.out.println(size);
        reader.close();
    }
    static boolean isSameValue(char leftDown, char rightDown, char value){
        return leftDown == value && rightDown == value;
    }
}