import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		String s = scanner.nextLine();
		String S = s.trim();	// 입력받은 문자열 앞뒤 공백 제거
		
		if (s.equals(" ") || s.isEmpty()==true) {
			System.out.println(0);    // 공백만 있거나 비었을 경우 0
		}
		else {
			String[] arr = S.split(" ");	// 공백 단위로 문자열 자르기
			System.out.println(arr.length);	// 길이 출력
		}
	}
}