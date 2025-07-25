import java.util.*;

class Solution {
    
    //-5~5 -> 0~10으로 좌표 범위 변경하여 계산 예정, 인덱스는 음수가 될 수 없기 때문
    //좌표 평면 벗어나는지 체크
    private boolean isValidMove(int nx, int ny){
        return nx >= 0 && nx < 11 && ny >=0 && ny < 11;
    }
    
    private HashMap<Character, int[]> location = new HashMap<>();
    
    //명령어별 이동방향 데이터 생성
    private void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('R', new int[]{1,0});
        location.put('L', new int[]{-1,0});
    }
    
    public int solution(String dirs) {
        initLocation();
        
        int x = 5, y = 5;
        //겹치는 좌표를 한 개로 처리하기 위함
        HashSet<String> answer = new HashSet<>();
        
        //명령어대로 움직이면서 직전 좌표 -> 이동 좌표 내용 저장
        for (int i=0; i<dirs.length(); i++){
            int[] offset =  location.get(dirs.charAt(i));
            
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            //벗어난 좌표인지 체크
            if(!isValidMove(nx, ny)){
                continue;
            }
            
            //[x,y] -> [nx,ny]로 이동하든 [nx,ny]->[x,y]로 이동하든 이미 "거쳐온 길"로 인식됨
            //거쳐온 경로 계산시, 총 경로의 개수 +1 하는 경우에는 방향성이 없음
            answer.add(x+""+y+""+nx+""+ny);
            answer.add(nx+""+ny+""+x+""+y);
            
            x = nx;
            y = ny;
        
        }
        
        //방향성이 없어 [x,y] -> [nx,ny]로 이동하든 [nx,ny]->[x,y] 모두 저장했으므로
        //마지막에는 나누기 2를 해주어야 한다
        return answer.size() / 2;
    }
    
   
}