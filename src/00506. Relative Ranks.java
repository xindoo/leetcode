import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Map<Integer, Integer> scores = new TreeMap<>();
        for (int i = 0; i < nums.length; i++)
            scores.put(nums[i], i);
        int rank = res.length;
        for (Map.Entry<Integer, Integer> e : scores.entrySet()) {
            if (rank == 1)
                res[e.getValue()] = "Gold Medal";
            else if (rank == 2)
                res[e.getValue()] = "Silver Medal";
            else if (rank == 3)
                res[e.getValue()] = "Bronze Medal";
            else
                res[e.getValue()] = String.valueOf(rank);
            rank--;
        }
        return res;
    }
}
