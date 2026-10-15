import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    HashSet<String> hashSet = new HashSet<>();
    
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nx = 0;
            int ny = 0;
            
            if (dir == 'U') {
                nx = x + dx[0]; 
                ny = y + dy[0]; 
            } else if (dir == 'D') {
                nx = x + dx[1]; 
                ny = y + dy[1]; 
            } else if (dir == 'L') {
                nx = x + dx[2]; 
                ny = y + dy[2]; 
            } else {
                nx = x + dx[3];
                ny = y + dy[3];
            }
            
            if (isOut(nx, ny)) {
                continue;
            }
            
            if (isNew(x, y, nx, ny)) {
              answer++;  
            } 
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    boolean isOut(int x, int y) {
        return x < -5 || x > 5 || y < -5 || y > 5;
    }
    
    boolean isNew(int x, int y, int nx, int ny) {
        String way = x + "," + y + "," + nx + "," + ny;
        
        if (hashSet.contains(way)) {
            return false;
        }
        
        hashSet.add(way);
        hashSet.add(nx + "," + ny + "," + x + "," + y);
        
        return true;
    }
}