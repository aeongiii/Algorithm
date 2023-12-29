import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int hour = scanner.nextInt();
		int min = scanner.nextInt();
		
		if (min<45) {
			if (hour == 0)  { hour = 23; }
			else 			{ hour -= 1; }
			min = min +60 -45;
		} else {
			min -= 45;
		}
		System.out.println(hour);
		System.out.println(min);
	}
}
