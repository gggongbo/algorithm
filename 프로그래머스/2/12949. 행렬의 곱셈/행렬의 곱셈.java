import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int x = 0; x < arr2[0].length; x++) {
                int sum = 0;
                for (int j = 0; j < arr1[i].length; j++) {
                    sum += arr1[i][j] * arr2[j][x];
                }
                answer[i][x] = sum;
            }
        }
        return answer;
    }
}