class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        // dp[i] = i번째 집까지 탐색햇을 때 훔칠 수 있는 돈의 최댓값
        int[] dp = new int[money.length];
        
        // 마지막 집 방문 X
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        
        for (int i=2; i<money.length-1; i++) {
            // 이전집 턴 경우, 안 턴 경우
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        
        int case1 = dp[money.length-2];
        
        // 첫 집 방문 x
        dp[0] = 0;
        dp[1] = money[1];
        
        for (int i=2; i<money.length; i++) {
            // 이전집 턴 경우, 안 턴 경우
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        
        int case2 = dp[money.length-1];
        
        return Math.max(case1, case2);
    }
}