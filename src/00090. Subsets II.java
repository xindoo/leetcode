import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < 1<<length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if ((i & (1<<j)) != 0) {
                    tempList.add(nums[j]);
                }
            }
            StringBuffer sb = new StringBuffer();
            tempList.stream().forEach(str -> sb.append(",").append(str));
            if (!set.contains(sb.toString())) {
                result.add(tempList);
                set.add(sb.toString());
            }
        }
        return result;
    }
}