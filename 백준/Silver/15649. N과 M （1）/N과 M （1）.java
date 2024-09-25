import java.util.Scanner;


//[백준] 15649번 - N과M(1) (Java)

public class Main {
    static int N, M;
    static boolean visited[];
    static int arr[];
    
    public void InputData() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        arr = new int[M];
    }

    public void dfs(int N, int M, int depth) {
        // 1. 종료조건
        if (depth == M) { // depth가 M가 같아지면 탐색 종료
            for (int x : arr) {
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }
        // 2. 함수본체
        for (int i=1; i<=N; i++) {
            if (visited[i]) continue; // 중복숫자 방문 방지, 이미 방문한 노드면 패스!
            visited[i] = true;
            arr[depth] = i; // depth(0과 1)에 맞게 방문한한 노드 저장
            dfs(N, M, depth+1); // 다음 노드 탐색 시작
            visited[i] = false; // 다음 탐색을 위해 방문처리 초기화
        }
    }

	public void Solve() {
        dfs(N, M, 0);

	}
    
	public static void main(String[] args)
	{
		Main m = new Main();
		m.InputData();
        m.Solve();
	}
}