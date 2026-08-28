class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        
        for (int i=1; i<size; i++) {
            for (int j=0; j<i+1; j++) {
                // [i][j]는 [i-1][j], [i-1][j-1] 중 큰거 + 자기값
                if (j == 0) { // 위에서 내려오는거밖에 안됨
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            
                if (dp[i][j] > answer) {
                    answer = dp[i][j];
                }
            }
        }
        
        return answer;
    }
}
