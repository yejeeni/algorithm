import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) { // 요청시각, 소요시간
        // int answer = 0;
        
        // 요청시각 오름차순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 소요시간 오름차순 pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int t = 0;
        int idx = 0; // 작업 인덱스
        int total = 0;
        int cnt = 0;
        while(cnt < jobs.length) {
            // t초에 작업 요청 넣은 작업이 있다면 모두 큐에 저장
            while (idx < jobs.length && jobs[idx][0] <= t) {
                pq.offer(jobs[idx]);
                idx++;
            }           
            
            // pq에서 맨앞에서 꺼내서 작업, 시간 반영
            if (!pq.isEmpty()) {
                int[] task = pq.poll();
                t += task[1];
                total += t - task[0];
                cnt++;
            } else { // pq가 비어있으면 제일 빠른 작업의 요청 시간으로 t를 조정
                t = jobs[idx][0];
                
            }     
        }
        
        return total / jobs.length;
    }
}