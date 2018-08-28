import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if (null == nums || nums.length == 0) {
            return list;
        }
        int s = nums[0];
        int e = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i-1]+1) {
                String str;
                if (s ==e) {
                    str = ""+s;

                } else {
                    str = ""+s+"->"+e;
                }
                list.add(str);
                if (i != nums.length) {
                    s = nums[i];
                    e = nums[i];
                }
            }
        }
        return list;
    }
}
