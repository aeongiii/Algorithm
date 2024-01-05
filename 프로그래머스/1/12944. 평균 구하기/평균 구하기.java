class Solution {
    public double solution(int[] arr) {
        int total = 0;
        for (int i=0; i<arr.length; i++) {
            total += arr[i];
        }
        double answer = (double) total / arr.length;
        return answer;
    }
}