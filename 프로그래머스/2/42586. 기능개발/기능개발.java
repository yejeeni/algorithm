import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        int[] times = new int[progresses.length];
        for (int i=0; i<progresses.length; i++) {
            int time = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            times[i] = time;
        }
        
        int last = times[0];
        int cnt = 1;
        List<Integer> result = new ArrayList<>();

        for (int i=1; i<progresses.length; i++) {
            if (times[i] <= last) {
                // 같은 묶음 cnt++
                cnt++;
            } else {
                // 새 묶음 시작 result에 cnt 추가, cnt 초기화, last 갱신
                result.add(cnt);
                cnt = 1;
                last = times[i];
            }
        }
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
}