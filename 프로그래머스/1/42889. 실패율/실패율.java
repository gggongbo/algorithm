import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        HashMap<Integer, Double> failRate = new HashMap<>();
        int[] notClearMembers = new int[N];
        int[] startMembers = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i + 1) {
                    startMembers[i]++;
                }
                if (stages[j] == i + 1) {
                    notClearMembers[i]++;
                }
            }

            if (startMembers[i] == 0) {
                failRate.put(i, (double) 0);
            } else {
                failRate.put(i, (double) notClearMembers[i] / (double) startMembers[i]);
            }

        }

        answer = failRate.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer, Double> entry)
                            -> entry.getValue(), Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey())
                        )
                .mapToInt(Map.Entry::getKey)
                .map(i -> i + 1)
                .toArray();
        
        return answer;
    }
}