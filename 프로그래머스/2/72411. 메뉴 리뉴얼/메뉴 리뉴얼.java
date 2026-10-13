// 단품 조합에 대해서만 세트 구성
import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 모든 손님의 주문에서 해당 크기 조합 생성
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            
            for (int c : course) {
                combination(new String(chars), 0, c, new StringBuilder(), map);                
            }
        } 
         
        // HashMap으로 각 조합 등장 횟수 카운트
        List<String> result = new ArrayList<>();
        for (int c : course) { // 길이 c
            int max = 0;
            
            // 길이가 c인 것들 중 최대
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().length() == c) {
                    max = Math.max(max, entry.getValue());
                }
            }
            
            // 최댓값이고 2번 이상인 것만 추가
            if (max >= 2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getKey().length() == c && entry.getValue() == max) {
                        result.add(entry.getKey());
                    }
                }                      
            }
        }
        
        Collections.sort(result);
                
        return result.toArray(new String[0]);
    }
    
    void combination(String order, int start, int c, StringBuilder current, HashMap<String, Integer> map) {
        if (current.length() == c) {
            String course = current.toString();
            map.put(course, map.getOrDefault(course, 0) + 1);
            return;
        }
        
        for (int i=start; i<order.length(); i++) {
            current.append(order.charAt(i));
            combination(order, i+1, c, current, map);
            current.deleteCharAt(current.length() - 1);
        }
    }
}