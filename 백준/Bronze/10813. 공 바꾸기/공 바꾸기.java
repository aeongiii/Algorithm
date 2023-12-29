import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		int[] arr = new int[N];
		for (int a = 0; a < N; a++) {
			arr[a] = a+1;
		}
		
		int t = 1;
		while (t <= M) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			int tmp;
				
			tmp = arr[i-1];
			arr[i-1] = arr[j-1];
			arr[j-1] = tmp;	
			
			t += 1;
		}
		
		for (int a = 0; a < arr.length; a++) {
			System.out.print(arr[a] + " ");	
		}
		
	}
}