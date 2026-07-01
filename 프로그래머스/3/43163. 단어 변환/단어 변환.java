import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {      
        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(begin);
        visited.add(begin);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨 크기
            level++;
            
            for (int i=0; i<size; i++) {
                String cur = queue.poll();
                
                for (String word : words) {
                    if (!visited.contains(word) && diffCheck(cur, word)) {
                        if (word.equals(target)) {
                            return level;
                        } else {
                            visited.add(word);
                            queue.add(word);   
                        }
                    }
                }
            }
        }
        
        return 0;
    }
    
    public boolean diffCheck(String before, String after) {
        int cnt = 0;
        for (int i=0; i<before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) {
                cnt++;
            }
        }
        
        if (cnt == 1) {
            return true;
        } else {
            return false;   
        }
    }
}