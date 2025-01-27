import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int[] coord_1 = { in.nextInt(), in.nextInt() };	// 첫 번째 좌표
		int[] coord_2 = { in.nextInt(), in.nextInt() };	// 두 번째 좌표
		int[] coord_3 = { in.nextInt(), in.nextInt() };	// 세 번째 좌표
 
		
		in.close();
		
		int x;
		int y;

		if (coord_1[0] == coord_2[0]) {	
			x = coord_3[0];
		}
		else if (coord_1[0] == coord_3[0]) {
			x = coord_2[0];
		}
		else {
			x = coord_1[0];
		}

		if (coord_1[1] == coord_2[1]) {
			y = coord_3[1];
		}
		else if (coord_1[1] == coord_3[1]) {
			y = coord_2[1];
		}
		else {
			y = coord_1[1];
		}
		System.out.println(x + " " + y);
		
	}
}