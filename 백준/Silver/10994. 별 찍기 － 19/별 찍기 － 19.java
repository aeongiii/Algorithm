
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 문제 분석
    1) 예제를 보면, N개의 사각형을 겹쳐 그리고 있다.
    2) 가장 큰 사각형의 가로와 세로는 각각 4N-3이다.
    3) 가장 마지막에는 정가운데에 *을 하나 찍고 마무리한다.

2. 제약 조건
   1 <= N <= 100

3. 의사결정
    1) N을 입력받는다.
    2) 가로와 세로가 각각 4N-3인 2차원 배열을 만든다.
    3) N부터 1까지 점점 작아지는 재귀함수를 호출한다.
    4) N > 1일때까지 함수를 호출하면서 점점 작은 사각형을 그린다. (4개의 변을 그린다)
    5) N = 1에 도달하면 정가운데에 *을 찍는다.
    6) 완성된 2차원 배열을 출력한다.

4. 문제 해결
    1) 코드 흐름을 만드는 과정에서 N과 4N-3을 혼용해서 사용했다. 혼용 방지를 위해 4N-3을 size로 선언하여 사용했다.
    2) *과 ' '를 모두 찍는 방식은 번거로워서, 처음에 빈칸으로 초기화한 뒤에 필요한 부분만 *을 찍는 방식으로 수정했다.
    3) 점점 작은 사각형을 그리기 위해서 row와 col의 시작 위치를 -2하여 재귀함수를 호출했는데, 알고보니 +2 했어야 작아지는거였다..
    4) 사각형 아래 변을 그리는 코드 : matrix[size-1][col + i]이 아니라, matrix[row+size-1][col + i]로 주어야 한다. 오른쪽 변도 마찬가지!
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 받기
        int size = 4 * N - 3;

        char[][] matrix = new char[size][size]; // 2차원 배열 생성

        // 2차원 배열을 ' '으로 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ' ';
            }
        }

        // 재귀함수 첫번째 호출
        square(matrix, 0, 0, size);

        // 완성된 배열을 한 줄씩 출력
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    // 재귀함수
    public static void square(char[][] matrix, int row, int col, int size) {

        // size=1인 경우, 정가운데 별 찍고 탈출
        if (size == 1) {
            matrix[row][col] = '*';
            return;
        }

        // size>1인 경우, 사각형 그리기
        for (int i = 0; i < size; i++) {
            matrix[row][col+i] = '*'; // 사각형 윗쪽 변 그리기
            matrix[row+size-1][col+i] = '*'; // 사각형 아래쪽 변 그리기
        }
        for (int i = 0; i < size; i++) {
            matrix[row+i][col] = '*'; // 사각형 왼쪽 변 그리기
            matrix[row+i][col+size-1] = '*'; // 사각형 오른쪽 변 그리기

        }

        // 재귀 함수 호출 (시작 위치를 변경하여 점점 작은 사각형으로 그린다)
        square(matrix, row+2, col+2, size-4);
    }

}