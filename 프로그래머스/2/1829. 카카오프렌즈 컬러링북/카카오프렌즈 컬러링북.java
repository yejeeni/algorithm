import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
    
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    numberOfArea++;
                    
                    int size = bfs(m, n, i, j, picture);
                    if (size > maxSizeOfOneArea) {
                        maxSizeOfOneArea = size;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public int bfs(int m, int n, int x, int y, int[][] picture) {
        int size = 1;
        
        visited[x][y] = true;
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            
            for (int i=0; i<4; i++) {
                    int nx = node[0] + dx[i];
                    int ny = node[1] + dy[i];
                    
                if (0 <= nx && nx < m 
                    && 0 <= ny && ny < n 
                    && picture[nx][ny] == picture[x][y] 
                    && !visited[nx][ny]) {
                    
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        
        return size;
    }
}