import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int yellowHeight = 0;
        int yellowWidth = 0;
        
        for (int height = 3; height < brown; height++) {
            yellowHeight = height - 2;
            yellowWidth = yellow / yellowHeight;
            
            int totalBrown = yellowWidth * 2 + yellowHeight * 2 + 4;
            
            if (yellowHeight * yellowWidth == yellow && totalBrown == brown) {
                break;
            }
        }
        return new int[]{yellowWidth + 2, yellowHeight + 2};
    }
}