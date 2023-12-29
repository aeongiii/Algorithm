import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int n = scanner.nextInt();
		int total = 0;
		for (int i = 1; i <= n; i++) {
			int price = scanner.nextInt();
			int many = scanner.nextInt();
			int nowprice = many * price;
			total += nowprice;
		}
		if (total == x)
			System.out.println("Yes");
		else 
			System.out.println("No");
	}
}