import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                continue;
                
            } else if (c >= 'a') { // 소문자
                c += n;
                if (c > 'z') {
                    c -= 26;
                }
                
            } else { //대문자
                c += n;
                if (c > 'Z') {
                    c -= 26;
                }
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}