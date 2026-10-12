import java.util.*;

class Solution {
    public long solution(String expression) {
        char[][] ops = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
        };
        
        StringBuilder sb = new StringBuilder();
        
        List<Long> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char now = expression.charAt(i);

            if (now == '+' || now == '-' || now == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                
                operators.add(now);
            } else {
                sb.append(now);
            }
        }
        
        nums.add(Long.parseLong(sb.toString())); 
        
        long max = Long.MIN_VALUE;
        
        for (int i=0; i<ops.length; i++) {
            List<Long> numsCopy = new ArrayList<>(nums);
            List<Character> opsCopy = new ArrayList<>(operators);
            
            for (int j=0; j<3; j++) {
                char nowOp = ops[i][j];
                int k = 0;
                
                while (k < opsCopy.size()) {
                    if (opsCopy.get(k) == nowOp) { // 연산자 나옴
                        // 연산자 앞뒤 숫자 연산하고 뒷숫자 빼기
                        long a = numsCopy.get(k);
                        long b = numsCopy.get(k+1);
                        long result;

                        if (nowOp == '+') {
                            result = a + b;
                        } else if (nowOp == '-') {
                            result = a - b;
                        } else {
                            result = a * b;
                        }
                        
                        numsCopy.set(k, result);
                        numsCopy.remove(k + 1);
                        opsCopy.remove(k);
                    } else {
                        k++;
                    }
                }
            }
            
            max = Math.max(max, Math.abs(numsCopy.get(0)));
        }
        

        return max;
    }
}