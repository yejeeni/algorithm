import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        int[] nums = new int[numbers.length()];
        for (int i=0; i<nums.length; i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        HashSet<Integer> hashSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()+1];
        
        per(1, 0, nums, hashSet, visited);
        
        for (int n : hashSet) {
           if (isPrime(n)) {
               answer++;
           }
        }
        
        return answer;
    }
    
    // 순열 만들기
    public void per(int depth, int num, int[] nums, HashSet<Integer> hashSet, boolean[] visited) {
        if (depth >= 1) {
            hashSet.add(num);
        }
        
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                per(depth+1, num * 10 + nums[i], nums, hashSet, visited);
                visited[i] = false;   
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n<2) {
            return false;
        };
        
        for (int i=2; i*i <= n; i++) {
            if (n%i == 0) {
                return false;
            };
        }
        
        return true;
    }
}