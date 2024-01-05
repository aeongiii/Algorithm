import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String S = scanner.nextLine();
		char[] Arr = new char[S.length()];
		for (int i=0; i<S.length(); i++) {
			Arr[i] = S.charAt(i);
		}
		
		int score = 0;
		
		for (int i=0; i<S.length(); i++) {
			char s = Arr[i];
			switch(s) {
				case 'A': case'B': case'C':
					score +=3;
					break;
				case 'D': case'E': case'F':
					score +=4;
					break;
				case 'G': case'H': case'I':
					score +=5;
					break;
				case 'J': case'K': case'L':
					score +=6;
					break;
				case 'M': case'N': case'O':
					score +=7;
					break;
				case 'P': case'Q': case'R': case'S':
					score +=8;
					break;
				case 'T': case'U': case'V':
					score +=9;
					break;
				case 'W': case'X': case'Y': case'Z':
					score +=10;
			}
		}
		
		System.out.println(score);
		
	}
}
