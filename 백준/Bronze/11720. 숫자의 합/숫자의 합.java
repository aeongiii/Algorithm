import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String num = scanner.nextLine();
        String[] arr = num.split("");
        int total = 0;
        for (int i = 0; i < n; i++) {
        	int b = Integer.valueOf(arr[i]);
        	total += b;
        }
        System.out.println(total);
    }
}