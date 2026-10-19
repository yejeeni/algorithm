import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String op : operations) {
            char cmd = op.charAt(0);
            int num = Integer.parseInt(op.split(" ")[1]);
            
            if (cmd =='I') {
                minPQ.offer(num);
                maxPQ.offer(num);
                
            } else {
                if (num == 1) {
                    if (!maxPQ.isEmpty()) {
                        minPQ.remove(maxPQ.poll());
                    }
                } else {
                    if (!minPQ.isEmpty()) {
                        maxPQ.remove(minPQ.poll());                        
                    }
                }
            }
        }
        
        if (minPQ.isEmpty()) {
                return new int[]{0, 0};
        }
        
        return new int[]{maxPQ.poll(), minPQ.poll()};
    }
}