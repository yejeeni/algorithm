class Solution {
    public int solution(int n, int[][] results) {
        // [A, B] : A가 B를 이김
        
        int answer = 0;
        boolean[][] win = new boolean[n+1][n+1];
        for (int i=0; i<results.length; i++) {
            int[] result = results[i];
            win[result[0]][result[1]] = true;
        }
        
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (win[i][k] && win[k][j]) { // i가 k 이기고, k가 j 이기면
                        win[i][j] = true; // i가 j도 이김
                    }
                }
            }
        }
        
        for (int i=1; i<=n; i++) {
            // 선수 i가 자기보다 강한 사람 수 + 자기보다 약한 사람 수 == n-1
            int winCount = 0;
            int loseCount = 0;
            
            for (int j=1; j<=n; j++) {
                if (i == j) {
                    continue;
                }
                
                if (win[i][j]) { 
                    winCount++;
                } else if (win[j][i]) {
                    loseCount++;
                }
            }
            
            if (winCount + loseCount == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}