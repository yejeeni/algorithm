import java.util.*;

class Solution {
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        // 래버를 경유하고 목적지까지 가는 최단경로 -> 경유지 bfs
        int mapRow = maps.length;
        int mapCol = maps[0].length();
        
        int distStoL[][] = new int[mapRow][mapCol]; // 방문여부 겸 출발지로부터 래버까지 거리
        
        ArrayDeque<int[]> queueStoL = new ArrayDeque<>(); // {x, y}
        int sToL = 0;
        
        ArrayDeque<int[]> queueLtoE = new ArrayDeque<>(); // {x, y}
        int lToE = 0;
        
        char[][] maze = new char[mapRow][mapCol];
        for (int i=0; i<mapRow; i++) {
            String row = maps[i];
            
            for (int j=0; j<mapCol; j++) {
                maze[i][j] = row.charAt(j);
                
                if (maze[i][j] == 'S') {
                    queueStoL.offer(new int[]{i, j}); // 시작점 큐에 추가
                }
                if (maze[i][j] == 'L') {
                    queueLtoE.offer(new int[]{i, j}); // 레버 
                }
            }
        }
        
        // S에서 레버까지 bfs
        while(!queueStoL.isEmpty()) {
            int[] node = queueStoL.poll();
            
            for (int i=0; i<4; i++) {
                int nr = node[0] + dr[i];
                int nc = node[1] + dc[i];
                
                if (0 <= nr && nr < mapRow && 0 <= nc && nc < mapCol && distStoL[nr][nc] == 0) {
                    if (maze[nr][nc] == 'L') { // 레버
                        sToL = distStoL[node[0]][node[1]] + 1;
                        queueStoL.clear();
                        break;
                        
                    } else if (maze[nr][nc] != 'X') { // 이동 가능 좌표
                        distStoL[nr][nc] = distStoL[node[0]][node[1]] + 1;
                        queueStoL.offer(new int[]{nr, nc});
                        
                    }
                }
            }
        }
        
        // 레버에서 E까지 bfs
        
        int distLtoE[][] = new int[mapRow][mapCol];
        
        while(!queueLtoE.isEmpty()) {
            int node[] = queueLtoE.poll();
            
            for (int i=0; i<4; i++) {
                int nr = node[0] + dr[i];
                int nc = node[1] + dc[i];
                
                if (0 <= nr && nr < mapRow && 0 <= nc && nc < mapCol && distLtoE[nr][nc] == 0) {
                    if (maze[nr][nc] == 'E') { // 출구
                        lToE = distLtoE[node[0]][node[1]] + 1;
                        queueLtoE.clear();
                        break;
                        
                    } else if (maze[nr][nc] != 'X') { // 이동 가능 좌표
                        distLtoE[nr][nc] = distLtoE[node[0]][node[1]] + 1;
                        queueLtoE.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        
        if (sToL == 0 || lToE == 0) {
            return -1;
        } else {
            return sToL + lToE;   
        }
    }
}