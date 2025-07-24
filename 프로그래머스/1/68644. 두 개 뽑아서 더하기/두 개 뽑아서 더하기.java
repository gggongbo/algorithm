import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> sumList = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumList.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = sumList.stream().distinct()
                .sorted().mapToInt(a -> a).toArray();
        
        return answer;
    }
}