import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		
		String strB = Integer.toString(B);
		
		int char1 = strB.charAt(0)-'0';
		int char2 = strB.charAt(1)-'0';
		int char3 = strB.charAt(2)-'0';
		
		System.out.println(A*char3);
		System.out.println(A*char2);
		System.out.println(A*char1);
		System.out.println(A*B);
		
	}

}
