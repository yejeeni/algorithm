import java.util.*;

class Solution {
    public int solution(int N, int number) { // N만 사용해서 number 만들기
        // dp[i] = N을 i번 사용해서 만들 수 있는 모든 숫자
        // dp[i] = dp[i-1], dp[i-2] 사칙연산 + dp[i-2], dp[i-1] 사칙연산
        
        int answer = 9;
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        
        for (int i=0; i<=9; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int i = 1; i <= 8; i++) {
            // 55, 555 같이 이어붙인 숫자
            String str = "";
            
            for (int j=1; j<=i; j++) {
                str += N; 
            }
            
            dp.get(i).add(Integer.parseInt(str));
            
            for (int j = 1; j < i; j++) {
                // dp[j]의 모든 값                
                // dp[i-j]의 모든 값
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i-j)) {
                        // 두 값을 +, -, *, /
                        // dp[i]에 넣기
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        
                        if (b != 0) {
                            dp.get(i).add(a / b);
                        } 
                        
                        dp.get(i).add(b + a);
                        dp.get(i).add(b - a);
                        dp.get(i).add(b * a);
                        
                        if (a != 0) {
                            dp.get(i).add(b / a);
                        } 
                    }
                }
                
            }
            
            for (int a : dp.get(i)) {
                if (a == number && i < answer) {
                    answer = i;
                }
            }

        }
        
        if (answer < 9) {
            return answer;
        } else {
            return -1;
        }
    }
}