class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        
        for (int i=0; i<land.length; i++) {
            for (int j=0; j<4; j++) {
                if (i==0) {
                    dp[0][j] = land[0][j];
                    continue;
                } 
                
                for (int k=0; k<4; k++) {
                    if (k != j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
                
                if (dp[i][j] > answer) {
                    answer = dp[i][j];
                }
            }
        }

        return answer;
    }
}