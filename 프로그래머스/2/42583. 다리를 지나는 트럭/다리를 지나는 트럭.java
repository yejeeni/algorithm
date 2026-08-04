import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {        
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for (int i=0; i<bridge_length; i++) {
            bridge.offer(0);
        }
        
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        for (int truckWeight : truck_weights) {
            trucks.offer(truckWeight);
        }
        
        int totalWeight = 0; // 다리 위 총 무게
        int count = 0;
        
        while(!trucks.isEmpty() || !bridge.isEmpty()) {
            // System.out.println(bridge);
            
            count++;
            
            // 다리 지나기
            if (!bridge.isEmpty()) {
                totalWeight -= bridge.poll();
            }
            
            // 다리에 오르기
            // 오를 수 있음
            if (!trucks.isEmpty()) {
                if (totalWeight + trucks.peek() <= weight) {
                    int truck = trucks.poll();
                    totalWeight += truck;      
                    bridge.offer(truck);

                    } else { // 오를 수 없음
                        bridge.offer(0);
                }
            }            
        }
        
        return count;
    }
}