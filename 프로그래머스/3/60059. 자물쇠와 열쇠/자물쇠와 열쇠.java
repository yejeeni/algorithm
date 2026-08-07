class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length; // 자물쇠 크기
        int m = key.length; // 열쇠 크기
        
        int p = m - 1; // 패딩 크기
        int size = n + p * 2;
        int[][] padding = new int[size][size];

        // 패딩
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                padding[i+p][j+p] = lock[i][j];
            }
        }
        
        for (int s=0; s<4; s++) {
            key = rotate(key);
        
        
            for (int r=0; r < size-m+1; r++) {
                for (int c=0; c < size-m+1; c++) {
                    // 키 맞추기
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            padding[r+i][c+j] += key[i][j];
                        }
                    }

                    // 키 확인
                    if (check(padding, p, n)) {
                        return true;
                    }

                    // key 다시 빼기
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            padding[r+i][c+j] -= key[i][j];   
                        }
                    }

                }
            }
        }
        return false;
    }
    
    // 시계방향 회전
    public int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] rotated = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                rotated[j][n-1-i] = key[i][j];
            }
        }
        
        return rotated;
    }
    
    // 키 열쇠 체크
    boolean check(int[][] padding, int p, int n) {
    for (int i=p; i < p+n; i++) {
        for (int j=p; j < p+n; j++) {
            if (padding[i][j] != 1) {
                return false;
                }
            }
        }
        
        return true;
    }
}