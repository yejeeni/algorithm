import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int right = people.length - 1; // 무거운거 인덱스
        int left = 0; // 가벼운거 인덱스
        
        while(left <= right) { 
            if (people[right] + people[left] <= limit) {
                left++;
            }
            
            right--;
            answer++;
           
        }
        
        return answer;
    }
}