import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> arr1 = new ArrayList<>(6); // 변의 개수는 6개로 고정

        // 평당 참외 개수 K 입력받기
        int k = sc.nextInt();
        sc.nextLine(); // K 입력 후 개행 처리

        // [방향, 길이] 저장하기
        for (int i = 0; i < 6; i++) {
            int direction = sc.nextInt();
            int length = sc.nextInt();
            sc.nextLine(); // 각 입력 후 개행 처리

            // 리스트에 [방향, 길이] 쌍 추가
            arr1.add(new int[]{direction, length});
        }

        sc.close();

        // 큰 사각형의 가로, 세로를 찾기
        int maxWidth = 0;
        int maxHeight = 0;
        int maxWidthIndex = -1;
        int maxHeightIndex = -1;

        // 가로 방향 (동, 서 방향: 1, 2)와 세로 방향 (남, 북 방향: 3, 4)에서 가장 긴 변 찾기
        for (int i = 0; i < 6; i++) {
            int direction = arr1.get(i)[0];
            int length = arr1.get(i)[1];

            if ((direction == 1 || direction == 2) && length > maxWidth) {
                maxWidth = length;
                maxWidthIndex = i;
            } else if ((direction == 3 || direction == 4) && length > maxHeight) {
                maxHeight = length;
                maxHeightIndex = i;
            }
        }

        // 작은 사각형의 가로, 세로 찾기
        int smallWidth = 0;
        int smallHeight = 0;

        // 가장 긴 변의 인덱스를 기준으로 인접한 두 변이 작은 사각형을 이룸
        smallWidth = Math.abs(arr1.get((maxWidthIndex + 5) % 6)[1] - arr1.get((maxWidthIndex + 1) % 6)[1]);
        smallHeight = Math.abs(arr1.get((maxHeightIndex + 5) % 6)[1] - arr1.get((maxHeightIndex + 1) % 6)[1]);

        // 큰 사각형의 면적과 작은 사각형의 면적 계산
        int bigArea = maxWidth * maxHeight;
        int smallArea = smallWidth * smallHeight;

        // 참외밭의 넓이를 구하고 총 참외 개수를 계산
        int totalArea = bigArea - smallArea;
        int totalMelons = totalArea * k;

        // 결과 출력
        System.out.println(totalMelons);
    }
}
