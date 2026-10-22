// x를 y로 
import java.util.*;

class Solution {
    
    int[] visited;
    
    public int solution(int x, int y, int n) {        
        visited = new int[y + 1];
        Arrays.fill(visited, -1);
        visited[x] = 0;
                
        
        return (x == y) ? 0 : bfs(x, y, n);
    }
    
    int bfs(int start, int y, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int[] nexts = new int[]{cur + n, cur * 2, cur * 3};
            
            for (int next : nexts) {
                if (next == y) {
                    return visited[cur] + 1;
                }
                
                if (next < y && visited[next] < 0) {
                    visited[next] = visited[cur] + 1;
                    queue.offer(next);
                }
            }
            
        }
        
        return -1;
    }
}