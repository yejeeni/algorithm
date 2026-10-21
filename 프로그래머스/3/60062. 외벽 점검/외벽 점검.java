import java.util.*;

class Solution {
    
    int min;
    int[] friends;
    int[] expandWeak;
    
    public int solution(int n, int[] weak, int[] dist) {
        min = Integer.MAX_VALUE;
        friends = dist; 
        expandWeak = new int[weak.length * 2]; // weak 확장 배열
        
        for (int i = 0; i < weak.length; i++) {
            expandWeak[i] = weak[i];
        }
        for (int i = 0; i < weak.length; i++) {
            expandWeak[i + weak.length] = weak[i] + n;
        }
        
        per(0, new int[dist.length], new boolean[dist.length]);
        
        
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
    
    // dist 투입 순열계산
    void per(int depth, int[] order, boolean[] visited) {
        // 경우의 수 하나 다 구함
        if (depth == order.length) { 
            // 투입 계산
            int weakLength = expandWeak.length / 2;
            
            for (int i = 0; i < weakLength; i++) { // i = 출발점
                boolean flag = false;
                // 지금 보는 애 인덱스
                int idx = 0;
                // 지금 보는 애가 갈 수 있는 거리
                int limit = order[idx] + expandWeak[i];
                
                for (int j = i; j < i + weakLength; j++) {
                    // 지금 보는 애가 못 가면
                    if (expandWeak[j] > limit) {
                        if (++idx >= order.length) {
                            flag = true;
                            break;
                        } 
                        
                        // 다음 애
                        limit = order[idx] + expandWeak[j];
                    }                    
                }
                
                if (!flag) {
                    min = Math.min(min, idx+1);
                }                
            }
            
            
        } else {
            // 경우의 수 마저 만들기
            for (int i = 0; i<visited.length; i++) {
                if (!visited[i]) {
                    order[depth] = friends[i];
                    visited[i] = true;
                    
                    per(depth + 1, order, visited);
                    
                    visited[i] = false;
                }
            }
        }
    }
}