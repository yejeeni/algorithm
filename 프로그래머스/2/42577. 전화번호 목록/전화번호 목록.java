import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        
        HashSet<String> map = new HashSet<>();
        
        for (int i=0; i<phone_book.length; i++) {
            map.add(phone_book[i]);
        }
        
        for (int i=0; i<phone_book.length; i++) {
            String str = phone_book[i];
            
            for (int j=1; j<str.length(); j++) {
                if (map.contains(str.substring(0, j))) {
                    answer = false;
                    break;
                }
            }

        }
        
        return answer;
    }
}