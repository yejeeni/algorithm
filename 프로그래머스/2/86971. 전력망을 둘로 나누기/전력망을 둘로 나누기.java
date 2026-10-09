import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        for (int i=0; i<wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int j=0; j<=n; j++) {
                graph.add(new ArrayList<>());
            }
            
            // i번 전선 제거한 그래프
            for (int j=0; j<wires.length; j++) {
                if (j == i) {
                    continue;
                }
                
                int a = wires[j][0];
                int b = wires[j][1];
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new ArrayDeque<>();
            
            visited[1] = true;
            queue.offer(1);
            
            int count = 1;
            
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                
                for (int next : graph.get(cur)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                        count++;
                    }
                }
            }
            
            if (Math.abs(n - count * 2) < min) {
                min = Math.abs(n - count * 2);
            }
        }
        
        
        return min;
    }
}