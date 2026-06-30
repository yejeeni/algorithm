class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddle = new boolean[m+1][n+1];
        for (int[] puddle : puddles) {
            isPuddle[puddle[0]][puddle[1]] = true;
        }
        
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        
        
        for (int i=2; i<=m; i++) {
            if (isPuddle[i][1]) {
                   dp[i][1] = 0;
            } else {
                dp[i][1] += dp[i-1][1];
            }
        }
        
        for (int j=2; j<=n; j++) {
            if (isPuddle[1][j]) {
                dp[1][j] = 0;
            } else {
                dp[1][j] += dp[1][j-1];
            }
        }
        
        // dp[i][j] = (i,j)까지 오는 경우의 수
        // 왼쪽에서 오는거, 위에서 오는거
        for (int i=2; i<=m; i++) {
            for (int j=2; j<=n; j++) {
               if (isPuddle[i][j]) {
                   dp[i][j] = 0;
               } else {
                   dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
               }
            }
        }
        
        return dp[m][n];
    }
    
    
}