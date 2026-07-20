import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        
        HashMap<String, String> hashMap = new HashMap<>(); // uid, 닉네임
        
        for (int i=0; i<record.length; i++) {
            String[] r = record[i].split(" "); 
            if (!r[0].equals("Leave")) {
                hashMap.put(r[1], r[2]); // 최종 닉네임
            }
        }
        
        for (int i=0; i<record.length; i++)  {            
            String[] r = record[i].split(" ");
            String cmd = r[0];
            String uid = r[1];
            
            String nickname = hashMap.get(uid);
            
            if (!cmd.equals("Change")){
                if (cmd.equals("Enter")) {
                    list.add(nickname + "님이 들어왔습니다.");
                } else{
                    list.add(nickname + "님이 나갔습니다.");
                }
            }
        }
        
        return list.toArray(new String[0]);
    }
}