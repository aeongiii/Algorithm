import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print(" ".repeat(t-i));
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
}