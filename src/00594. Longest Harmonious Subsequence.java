import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int maxans = 0;
        for (int num : map.keySet()) {
            if (map.getOrDefault(num+1, 0) == 0) {
                continue;
            }
            maxans = Math.max(maxans, map.get(num) + map.getOrDefault(num+1, 0));
        }
        return maxans;
    }
}