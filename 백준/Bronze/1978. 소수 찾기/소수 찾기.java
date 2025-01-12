import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int num = 0;

        for(int i=0;i<arr.length;i++) {
			int j;
			for(j=2;j<arr[i];j++) {
				if(arr[i]%j==0) { 
					break; 
				}
			}
			if(arr[i]==j) {
				num++;
			}
		}
		System.out.println(num);
	}
}