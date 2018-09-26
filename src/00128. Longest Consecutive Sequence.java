import java.util.HashMap;
import java.util.Map;

/**
 * 虽然是hard题, 但其实也简单, 把所有数都存到HashMap里, 这样就可以以O(1)的时间复杂度
 * 判断一个数相邻的数是否存在了, 总的复杂度O(n), 满足题目要求. 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }
            int curLen = 1;
            int i = num - 1;
            while (map.getOrDefault(i, 0) > 0) {
                curLen++;
                map.put(i, map.get(i) - 1);
                i--;
            }
            i = num + 1;
            while (map.getOrDefault(i, 0) > 0) {
                curLen++;
                map.put(i, map.get(i) - 1);
                i++;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}