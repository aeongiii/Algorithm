import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        long n = sc.nextInt()-2;
 
        System.out.println(((n*n*n)+(3*n*n)+(2*n))/6);
        System.out.println(3);
        
    }
}