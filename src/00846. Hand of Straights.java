import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < hand.length; i++) {
            int cnt = map.getOrDefault(hand[i], 0);
            map.put(hand[i], cnt+1);
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            while (map.get(hand[i]) > 0) {
                for (int j = 0; j < W; j++) {
                    int cnt = map.getOrDefault(hand[i] + j, -1);
                    if (cnt == -1)
                        return false;
                    map.put(hand[i] + j, cnt - 1);
                }
            }
        }
        return true;
    }
}