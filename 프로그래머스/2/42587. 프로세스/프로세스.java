import java.util.*;

class Solution {
    // 우선순위가 높은 순으로 실행
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<priorities.length; i++) {
            queue.add(new int[]{priorities[i], i}); // 우선순위, 원래 인덱스
        }
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean hasHigher = false;
            
            for (int[] q : queue) {
                if (cur[0] < q[0]) { // 맨앞보다 우선순위가 더 높은 작업이 있음
                    hasHigher = true;
                    break;
                }
            }
            
            if (hasHigher) {
                queue.add(cur); // 뒤로
            } else {
                answer++;
                if (cur[1] == location) {
                    break;
                }
            }
        }
        return answer;
    }
}