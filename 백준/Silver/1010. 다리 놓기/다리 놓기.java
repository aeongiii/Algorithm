import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			//result는 연산값을 저장해줄 것인데 처음에 곱하기때문에 1로 선언해준다.
			long result = 1;
			
			//곱하고 나누기를 반복할때마다 처리해준다.
			//나누기 처음 값은 1이지만 반복문은 j가 0부터 시작하기 때문에 +1을 해준다.
			for(int j = 0; j < N; j++) {
				result *= (M - j);
				result /= (j + 1);
			}
			System.out.println(result);
		}
	}

}