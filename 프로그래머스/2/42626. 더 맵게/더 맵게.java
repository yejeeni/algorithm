import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Arrays.sort(scoville);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int s : scoville) {
            queue.offer(s);
        }
        
        while (queue.peek() < K) { // 젤 작은 스코빌값이 K 밑일때만
            if (queue.size() == 1) { // 더못섞음
                return -1;
            }
            
            int s1 = queue.poll();
            int s2 = queue.poll();
            
            queue.offer(s1 + s2 * 2);
            answer++;
        }
        
        return answer;
    }
}