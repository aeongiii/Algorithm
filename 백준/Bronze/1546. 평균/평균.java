import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 과목 개수 입력
        int N = scanner.nextInt();

        // 성적 입력
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = scanner.nextInt();
        }

        // 최고 점수 찾기
        int maxScore = 0;
        for (int score : scores) {
            maxScore = Math.max(maxScore, score);
        }

        // 새로운 점수 계산 및 총합 구하기
        double total = 0;
        for (int score : scores) {
            total += (double) score / maxScore * 100;
        }

        // 평균 출력
        System.out.println(total / N);
    }
}
