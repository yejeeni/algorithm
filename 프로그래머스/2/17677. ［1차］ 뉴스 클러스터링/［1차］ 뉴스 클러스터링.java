import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        HashMap<String, Integer> str1Map = makeMap(str1);
        HashMap<String, Integer> str2Map = makeMap(str2);
        
        int in = 0; // 교
        int union = 0; // 합
        
        // 교집합 = 각 원소 min(A개수, B개수)
        // 합집합 = 각 원소 max(A개수, B개수)
        for (Map.Entry<String, Integer> entry : str1Map.entrySet()) {
            String key = entry.getKey();
            int value1 = entry.getValue();
            int value2 = str2Map.getOrDefault(key, 0);
            
            in += Math.min(value1, value2);
            union += Math.max(value1, value2);
        }
        
        for (Map.Entry<String, Integer> entry : str2Map.entrySet()) {
            String key = entry.getKey(); // 2것
            int value = entry.getValue();
            
            if (str1Map.getOrDefault(key, 0) == 0) { // 1에는 없는데 2에만 있는거
                union += value; // 합집합에 추가
            }
        }
        
        double j = 0;
        if (in == 0 && union == 0) {
            j = 1;
        } else {
            j = (double) in / union;
        }
        
        return (int) (j * 65536);
    }
    
    public HashMap<String, Integer> makeMap(String str) {
         HashMap<String, Integer> strMap = new HashMap<>();
        
         for (int i=0; i<str.length()-1; i++) {
            String sub = str.substring(i, i+2);
            
            if (Character.isLetter(sub.charAt(0)) && Character.isLetter(sub.charAt(1))) {
                strMap.put(sub, strMap.getOrDefault(sub, 0)+1);
            }
        }
        
        return strMap;
    }
    
}