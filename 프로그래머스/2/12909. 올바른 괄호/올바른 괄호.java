import java.util.*;

// LIFO 스택
class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else { // ')' 들어옴
                if (!stack.isEmpty()) {
                    stack.pop();   
                } else {
                    return false;
                }
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        if (!stack.isEmpty()) {
            return false;
        } else {
                 return true;   
        }
    }
}