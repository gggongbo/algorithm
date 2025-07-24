import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int columns = arr1.length;
        int rows = arr2[0].length;
        int multipleCount = arr1[0].length;
        
        int[][] answer = new int[columns][rows];

        for (int c = 0; c < columns; c++) {
            for (int r = 0; r < rows; r++) {
                for (int m = 0; m < multipleCount; m++) {
                    answer[c][r] += arr1[c][m] * arr2[m][r];
                }
            }
        }
        
        return answer;
    }
}
