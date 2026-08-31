import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = s.length();
        
        for (int i=0; i<size; i++) {
            boolean isCorrect = true;
            
            String spinS = (s+s).substring(i, i+size);
            
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            for (int j=0; j<size; j++) {                
                Character c = spinS.charAt(j);
                
                // c가 여는괄호면 push
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(spinS.charAt(j));
                    
                } else {
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }
                    
                    // c가 닫는괄호면 pop
                    Character cc = stack.pop();
                    
                    if ((cc == '(' && c == ')') || 
                       (cc == '{' && c == '}') ||
                       (cc == '[' && c == ']')) {
                        continue;
                    } else {
                        // 어차피 안됨
                        isCorrect = false;
                        break;
                    }
                }
            }
            
            if (stack.isEmpty() && isCorrect) {
                answer++;
            }
            
        }
        
        return answer;
    }
}