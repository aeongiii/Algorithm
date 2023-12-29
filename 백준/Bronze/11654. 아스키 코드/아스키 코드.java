import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String A = scanner.nextLine();
        
        for (int i = 0; i < A.length(); i++) {
        	char tmp = A.charAt(i);
        	System.out.println((int) tmp);
        }
    }
}