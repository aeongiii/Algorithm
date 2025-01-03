import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
 
public class Main {
  
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();
        int K = sc.nextInt();
 
        int kthDivisor = findKthDivisor(N, K);
 
        if (kthDivisor != -1) {
            System.out.print(kthDivisor);  // K 번째 약수 출력
        } else {
            System.out.print(0);  // K 번째 약수가 없을때
        }
    }
 
    public static int findKthDivisor (int N, int K) {
        List<Integer> divisors = new ArrayList<>();
 
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i);  // 나눈 나머지가 0 일때 리스트에 추가
            }
        }
 
        if (K > divisors.size()) {
            return -1;  // 약수가 존재하지 않거나 K 번째로 작은 수를 찾을 수 없음
        }
 
        return divisors.get(K - 1);
    }
    
}