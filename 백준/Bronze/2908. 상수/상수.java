import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		int t = 0;
		while (true) {
			int num = scanner.nextInt();
			
			String num1 = Integer.toString(num%10);
			String num2 = Integer.toString(num/10%10);
			String num3 = Integer.toString(num/100%10);
			
			String reverseNum = num1 + num2 + num3;
			
			intlist.add(Integer.parseInt(reverseNum));

			t ++;
			
			if (t == 2) {
				break;
			}
		}
			int A = intlist.get(0);
			int B = intlist.get(1);
		
			if (A>B) {
				System.out.println(A);
			} else {
				System.out.println(B);
			}
	}
}
