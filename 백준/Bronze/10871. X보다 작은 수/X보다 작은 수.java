import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			int num = scanner.nextInt();
			list.add(num);
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < X) {
				System.out.print(list.get(i) + " ");
			}
		}
	}
}