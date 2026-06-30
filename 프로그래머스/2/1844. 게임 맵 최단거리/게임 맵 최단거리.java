import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {               
        // 상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        // 초기화
        int r = 0;
        int c = 0;
        int n = maps.length;
        int m = maps[0].length;
        queue.add(new int[]{r, c, 1});
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            
            // 종점
            if (node[0] == n-1 && node[1] == m-1) {
                return node[2];
            }
            

            for (int i=0; i<4; i++) {
                int nr = node[0] + dr[i];
                int nc = node[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                    maps[nr][nc] = 0;
                    queue.add(new int[]{nr, nc, node[2]+1});
                }
            }
        }
        
        return -1;
    }
    
}