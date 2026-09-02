import java.util.*;

class Solution {
    
    static boolean[] used; // 항공권 사용여부
    static HashMap<String, List<String[]>> map = new HashMap<>(); // 출발 공항명, 도착지 목록
    static ArrayList<String> path = new ArrayList<>(); // 방문 순서
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> a[0].compareTo(b[0])); // 알파벳순
        
        int idx = 0;
        
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            
            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            } 
            
            map.get(start).add(new String[]{end, String.valueOf(idx)});
            idx++;
        }
        
        path.add("ICN");
        dfs("ICN", tickets.length);
        
        
        return path.toArray(new String[0]); 
    }
    
    public boolean dfs(String start, int size) {
        if (path.size() == size + 1) { // 출발지 인천 + 모든 티켓 수
            return true;
        }
        
        List<String[]> ends = map.getOrDefault(start, new ArrayList<String[]>()); // 가능한 도착지 목록
        // 도착지명 정렬
        ends.sort((a, b) -> {
                return a[0].compareTo(b[0]);
        });
        
        for (String[] nameIdx : ends) {
            String name = nameIdx[0];
            int idx = Integer.parseInt(nameIdx[1]);
            
            // 사용여부 체크
            if (used[idx]) {
                continue;
            }
            
            used[idx] = true; // 티켓 사용
            path.add(name); // 경유 공항 추가
            
            // =============
            // for (String p : path) {
            //     System.out.print(p + " ");
            // }
            // System.out.println(" ");
            // =============
            
            // 재귀
            if (dfs(name, size)) {    
                return true;
                
            } else {
                path.remove(path.size()-1); // 백트래킹
                used[idx] = false;   
            }
        }
        
        return false;
    }
}