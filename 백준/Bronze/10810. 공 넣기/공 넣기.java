import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		int[] arr = new int[N];
		
		for (int a = 0; a < M; a++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			int k = scanner.nextInt();
			int t = 0;

			while (i <= j) {
				int index = i-1;
				arr[index] = k;
				i += 1;
			}
		}
		for (int a = 0; a < arr.length; a++) {
			System.out.print(arr[a] + " ");	
		}
		
	}
}