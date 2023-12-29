import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Integer> arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int start = A-1;
            int B = scanner.nextInt();
            int end = B-1;

            reverseRange(arr, start, end);
        }

        // 리스트의 모든 내용을 공백으로 구분하여 출력
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void reverseRange(List<Integer> arr, int start, int end) {
        List<Integer> subList = arr.subList(start, end +1);
        Collections.reverse(subList);
    }
}