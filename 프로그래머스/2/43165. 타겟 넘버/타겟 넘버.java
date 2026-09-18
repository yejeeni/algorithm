class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {    
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int idx, int current) {
        if (idx == numbers.length) {
            if (current == target) {
                answer++;
                return;
            }
            
            return;
        }
         
        // + 선택
        dfs(numbers, target, idx+1, current + numbers[idx]);
         
        // - 선택
        dfs(numbers, target, idx+1, current - numbers[idx]);
    }
}