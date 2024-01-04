import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> scoreArr = new ArrayList<>(); // 각 섬에서의 점수를 저장할 리스트

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X') {		// maps 문자열 배열의 i번째 요소 중 j번째 글자가 "정수"이면 점수 계산 start 
                    int score = calculateScore(maps, i, j);
                    scoreArr.add(score);
                }
            }
        }

        Collections.sort(scoreArr);	// 오름차순 정렬

        if (scoreArr.isEmpty()) {
            return new int[]{-1};	// 비었을 경우 -1 반환
        } else {
            int[] answer = new int[scoreArr.size()];
            for (int i = 0; i < scoreArr.size(); i++) {
                answer[i] = scoreArr.get(i);
            }
            return answer;
        }
    }

    private int calculateScore(String[] maps, int row, int col) {
        int score = 0;
        if (maps[row].charAt(col) != 'X') { // maps 문자열 배열의 i번째 요소 중 j번째 글자가 "정수"이면 점수 계산 start 
            score += Character.getNumericValue(maps[row].charAt(col));	// 일단 그 숫자도 점수에 합산하고
            maps[row] = maps[row].substring(0, col) + 'X' + maps[row].substring(col + 1);	// 이미 합산한 내용이므로, 중복합산 되지 않도록 X로 변경

            if (row - 1 >= 0 && maps[row - 1].charAt(col) != 'X') {	// 위쪽이 섬이 아닌 경우 위쪽 숫자 합산
                score += calculateScore(maps, row - 1, col);
            }
            if (row + 1 < maps.length && maps[row + 1].charAt(col) != 'X') { // 아래쪽이 섬이 아닌 경우 아래쪽 숫자 합산
                score += calculateScore(maps, row + 1, col);
            }
            if (col - 1 >= 0 && maps[row].charAt(col - 1) != 'X') {  // 왼쪽이 섬이 아닌 경우 왼쪽 숫자 합산
                score += calculateScore(maps, row, col - 1);
            }
            if (col + 1 < maps[row].length() && maps[row].charAt(col + 1) != 'X') { // 오른쪽이 섬이 아닌 경우 오른쪽 숫자 합산
                score += calculateScore(maps, row, col + 1);
            }
        }
        return score;	// 합산한 점수 리턴
    }
}
