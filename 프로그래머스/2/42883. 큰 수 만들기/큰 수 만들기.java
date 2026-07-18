import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peekLast() < c && k > 0) { 
                stack.pollLast();
                k--;
            }
            
            stack.addLast(c);
        }
        
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}