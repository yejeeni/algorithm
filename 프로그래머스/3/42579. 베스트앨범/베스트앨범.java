import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 장르 순, 장르 내 재생 수/고유번호 낮은 순, 최대 2개
        
        // 장르별 총 재생수
        HashMap<String, Integer> genrePlay = new HashMap<>();
        // 장르 내 재생수
        HashMap<String, List<int[]>> genreSongs = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genrePlay.put(genre, genrePlay.getOrDefault(genre, 0) + play);
            
            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }
            genreSongs.get(genre).add(new int[]{i, play});
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(genrePlay.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue()); // 재생수 정렬
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i=0; i<list.size(); i++) {
            String genre = list.get(i).getKey(); // 많이 재생된 장르순
            
            // 해당 장르 노래 꺼내기
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> {
                if (a[1] != b[1]) {
                    return b[1] - a[1]; // 재생순
                } else {
                    return a[0] - b[0]; // 번호 낮은 순
                }
            });
            
            int idx = 0;
            while(idx < Math.min(2, songs.size())) {
                result.add(songs.get(idx)[0]);
                idx++;
            }
        }
        
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}