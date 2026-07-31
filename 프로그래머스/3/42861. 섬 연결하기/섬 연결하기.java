import java.util.*;

class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        // 0 1 다리번호 2 비용
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        parent = new int[n];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    public void union(int a, int b) {
        a = find(a); 
        b = find(b);
        
        if (a != b) {
            parent[a] = b;
        }
    }
}