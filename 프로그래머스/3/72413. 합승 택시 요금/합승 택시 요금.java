import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<int[]>> graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<int[]>());
        }
        
        for (int[] fare : fares) {
            int c = fare[0]; // 구간
            int d = fare[1];
            int f = fare[2]; // 요금
            
            graph.get(c).add(new int[]{d, f});
            graph.get(d).add(new int[]{c, f});
        }
        
        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);
        
        int answer = Integer.MAX_VALUE;
        // 겹치는 구간 k 찾기
        // dist(s->k) + dist(k->a) + dist(k->b)
        for(int k=1; k<=n; k++) {
            answer = Math.min(distS[k] + distA[k] + distB[k], answer);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {거리, 노드}
        pq.offer(new int[]{0, start});
        
        while(!pq.isEmpty()) {
            int cur[] = pq.poll();
            int curDist = cur[0];
            int curNode = cur[1];
            
            if (dist[curNode] < curDist) {
                continue;
            }
            
            for (int[] x : graph.get(curNode)) {
                int nextNode = x[0];
                int weight = x[1];
                
                int nextDist = curDist + weight;
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.offer(new int[]{nextDist, nextNode});
                }
                
            }
        }     
        
        return dist;
    }
}