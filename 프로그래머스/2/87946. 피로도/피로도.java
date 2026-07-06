import java.util.*;

class Solution {
    // 최소 피로도: 입장조건
    // 소모 피로도: 소모
    // 최대한 많이 탐험
    public int solution(int k, int[][] dungeons) { 
        // k = 현재 피로도 
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        
        return per(k, dungeons, visited);
    }
    
    public int per(int k, int[][] dungeons, boolean[] visited) {
        int max = 0;
        int result = 0;
        
        for (int i=0; i<dungeons.length; i++) {
        
            if (!visited[i] && dungeons[i][0] <= k) {
                k -= dungeons[i][1];
                visited[i] = true;
    
                result = 1 + per(k, dungeons, visited); // 지금 + 앞으로 방문가능 수
    
                visited[i] = false;
                k += dungeons[i][1];
            }
            max = Math.max(result, max);
            
        }
        
        return max;
    }
}