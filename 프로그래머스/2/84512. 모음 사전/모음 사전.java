import java.util.*;

class Solution {
    
    String[] list = {"A", "E", "I", "O", "U"};
    int answer;
    boolean flag;
    
    public int solution(String word) {
        
        for (int i=0; i<list.length; i++) {
            makeWord(list[i], word);
        }
        
        
        return answer;
    }
    
    void makeWord(String now, String target) {
        if (flag) {
            return;
        }
        
        answer++;
        
        if (now.equals(target)) {
            flag = true;
            return;
        }
        
        if (now.length() == 5) {
            return;
        }
        
        for (int i=0; i<list.length; i++) {
            makeWord(now + list[i], target);
        }
    }
}