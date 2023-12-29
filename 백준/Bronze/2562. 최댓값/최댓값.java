import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> sortedlist = new ArrayList<Integer>();
		
		for (int i = 0; i < 9; i++) {
			int num = scanner.nextInt();
			list.add(num);
			sortedlist.add(num);
		}
		Collections.sort(sortedlist);
		System.out.println(sortedlist.get(8));
		for (int i=0; i < 9; i++) {
			if (sortedlist.get(8) == list.get(i)) {
				System.out.println(i+1);
			}
		}
	}
}
