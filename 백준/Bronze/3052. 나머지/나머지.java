import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>(); 

		int t = 0;
		int num0 = scanner.nextInt();
		int remain0 = num0%42;
		arr.add(remain0);
		
		while (t <9) {
			int num = scanner.nextInt();
			int remain = num%42;
			for (int i=0; i < arr.size(); i++) {
				if (!arr.contains(remain)) {
					arr.add(remain);					
				}
			}
			t++;
		}
		
		System.out.println(arr.size());
		
	}
}