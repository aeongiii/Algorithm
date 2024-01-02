import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();		// 테스트 케이스 개수
//		scanner.nextLine();
		for(int i=0; i<T; i++) {
			int R = scanner.nextInt();	// 문자 반복 횟수
//			scanner.nextLine();
			String S = scanner.next();	// 문자열 입력 시 공백은 받지 않도록 next 사용
			
			for (int j=0; j<S.length(); j++) {
				for (int k=0; k<R; k++) {
					System.out.print(S.charAt(j));
				}
			}
			System.out.println();

		}
		
		
	}

}