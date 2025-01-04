import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num != -1){
            ArrayList<Integer> divisors = new ArrayList<>();
            for(int i = 1; i < num; i++){
                if(num % i == 0) divisors.add(i);
            }
            int sum = divisors.stream().mapToInt(n -> n).sum();
            if(sum == num){
                System.out.print(num + " = ");
                int size = divisors.size();
                for(int i = 0; i < size-1; i++){
                    System.out.print(divisors.get(i) + " + ");
                }
                System.out.println(divisors.get(size-1));
            }
            else{
                System.out.println(num + " is NOT perfect.");
            }
            num = sc.nextInt();
        }
    }
}