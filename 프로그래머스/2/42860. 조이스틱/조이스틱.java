class Solution {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();

        // 알파벳 변경 횟수
        for (int i=0; i<size; i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);
        }

        // 커서 이동 횟수
        int move = size - 1;

        for (int i=0; i<size; i++) {
            int next = i + 1; // 다음에 처리할 문자 인덱스

            while (next < size && name.charAt(next) == 'A') {
                next++;
            }

            int right = i*2 + size - next;
            int left = (size - next) * 2 + i;

            move = Math.min(move, Math.min(right, left));
        }

        return answer + move;
    }
}