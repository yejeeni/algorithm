import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<road.length; i++) {
            int[] r = road[i];
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
    
        // {노드, 가중치}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (d > dist[u]) {
                continue;
            }
            
            for (int[] node : graph.get(u)) {
                int next = node[0];
                int nw =  d + node[1];
                if (nw < dist[next]) {
                    dist[next] = nw;
                    pq.offer(new int[]{next, nw});
                }
            }
            
        }
        
        for (int i=1; i<=N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
                                   
        
        return answer;
    }
    
}