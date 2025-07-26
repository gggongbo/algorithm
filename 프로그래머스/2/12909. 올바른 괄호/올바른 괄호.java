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
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
            
        }

        return stack.isEmpty();
    }
}