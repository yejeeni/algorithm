import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        int answer = s.length();
        
        for (int i=1; i<=s.length() / 2; i++) { // 자르는 단위
            String sub = s.substring(0, i); // 맨앞 압축 단위
            int count = 1;
            
            for (int j=i; j<s.length(); j+=i) {
                String next = s.substring(j, Math.min(j+i, s.length())); // 단위 안 넘게
                
                if (sub.equals(next)) { // 단위 일치
                    count++;
                
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(sub);
                    
                    sub = next;
                    count = 1;
                }
            }
             if (count > 1) {
                sb.append(count);
            }
            sb.append(sub);
            
             // 압축 더 짧게됐는지
            if (sb.length() < answer) {
                answer = sb.length();
            }
            sb.setLength(0);
        }
        
        return answer;
    }
}