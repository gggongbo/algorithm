import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
         //0~N+1이 아니라 1~N+2에 데이터를 담을 예정
        int [] challengers = new int[N+2];
        
        for(int stage: stages){
            //stages[i]에서 머물러있는 스테이지를 알 수 있음
            //challengers[stages[i]]로 스테이지를 인덱스로 하여 총 몇명의 도전자가 있는지 저장 가능
            challengers[stage] ++;
        }
        
        //전체 도전자의 수
        double total = stages.length;
        HashMap<Integer,Double> failRates = new HashMap<>();
        
        for(int i=1; i<=N; i++){
            if(challengers[i] == 0){
                failRates.put(i, 0.);
            } else {
                //stages[i]는 1부터 시작하므로
                //1부터 시작했을때 전체 인원이 1스테이지는 머무르거나, 클리어했을 것임
                failRates.put(i, challengers[i] / total);
                //해당 스테이지에 머물러있는 사람들을 제거해줘야
                //다음 스테이지에 머무르거나 클리어한 전체인원 계산이 가능
                total -= challengers[i];
            }
            
        }
        
        int[] answer = failRates.entrySet().stream()
                    .sorted((o1, o2) ->
                           o1.getValue().equals(o2.getValue())
                           ? Integer.compare(o1.getKey(), o2.getKey())
                           : Double.compare(o2.getValue(), o1.getValue()))
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        return answer;
    }
}
