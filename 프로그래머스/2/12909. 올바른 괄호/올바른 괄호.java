import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char c : chars){
            if(c == '('){
                stack.push(c);
            } else {
                //stack.pop() == c인 경우가 생각이 안나지만, 안전장치로 추가
                if(stack.isEmpty() || stack.pop() == c){
                    return false;
                }
            }
            
        }

        return stack.isEmpty();
    }
}
