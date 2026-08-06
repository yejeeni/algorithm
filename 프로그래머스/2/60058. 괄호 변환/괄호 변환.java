import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }
        
        String u = "";
        String v = "";
        
        int left = 0;
        int right = 0;
        
        // 균형잡힌 괄호 분리
        for (int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                // substring(시작, 끝) 시작부터 끝 바로앞까지. 인덱스 0부터
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                break;
            }
        }
        
        // 올바른 괄호 검사
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        boolean isBalance = true;
        for (int i=0; i<u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    isBalance = false;
                    break;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            isBalance = false;
        }
        
        // u가 올바른 괄호일 경우
        // 문자열 v에 대해 1부터 다시 수행 (이 결과 문자열을 u에 이어붙인 후 반환)
        if (isBalance) {
            return u + solution(v);
            
        } else { // u가 올바른 괄호 아닐 경우
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
            String str = "(";
            
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
            str += solution(v);
            
            // 4-3. ')'를 다시 붙입니다.
            str += ")";
            
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
            u = u.substring(1, u.length()-1);   
            for (int i=0; i<u.length(); i++) {
                if (u.charAt(i) == '(') {
                    str += ')';
                } else {
                    str += '(';
                }
            }
            
            // 4-5. 생성된 문자열을 반환합니다.
            return str;
        }
        
    }
}