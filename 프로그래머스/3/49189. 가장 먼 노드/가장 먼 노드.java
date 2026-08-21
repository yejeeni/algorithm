import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visited = new boolean[n+1];
        dist = new int[n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        bfs(1);
        
        int maxDist = 0;
        for (int i=1; i<=n; i++) {
            if (maxDist < dist[i]) {
                maxDist = dist[i];
            }
        }
        
        for (int i=1; i<=n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int x) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        queue.offer(x);
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    dist[next] = dist[node] + 1;
                    
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}