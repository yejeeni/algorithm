import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] matrix = new int[rows][columns];
        int num = 1;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                matrix[i][j] = num++;
            }
        }
            
        int idx = 0;
        for (int[] query : queries) {
            int x1 = query[0]-1; 
            int y1 = query[1]-1;
            int x2 = query[2]-1; 
            int y2 = query[3]-1;
            
            int before = matrix[x1][y1];
            int min = before;
            
            // 상
            for (int y=y1; y<=y2; y++) {
                int next = matrix[x1][y];
                matrix[x1][y] = before;
                before = next;
                
                if (before < min) {
                    min = before;
                }
            }
            
            // 우
            // x는 증가, y는 y2 그대로
            for (int x=x1+1; x<=x2; x++) {
                int next = matrix[x][y2];
                matrix[x][y2] = before;
                before = next;
                
                if (before < min) {
                    min = before;
                }
            }
            
            // 하
            // x는 x2, y는 y2에서 y1까지
            for (int y=y2-1; y>=y1; y--) {
                int next = matrix[x2][y];
                matrix[x2][y] = before;
                before = next;
                
                if (before < min) {
                    min = before;
                }
            }
            
            // 좌
            // x는 x2에서 x1까지, y는 y1
            for (int x=x2-1; x>=x1; x--) {
                int next = matrix[x][y1];
                matrix[x][y1] = before;
                before = next;
                
                if (before < min) {
                    min = before;
                }
            }
            
            answer[idx++] = min;
        }
        
        return answer;
    }
}