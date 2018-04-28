class Solution {
    public int maximumGap(int[] nums) {
        if (null == nums || nums.length < 2)
            return 0;
        int[] zeronums = new int[nums.length];
        int[] onenums = new int[nums.length];
        for (int i = 0; i < 31; i++) {
            int cur = 1 << i;
            int cntzero = 0;
            int cntone = 0;
            for (int num : nums) {
                if ((num&cur) == 0) {
                    zeronums[cntzero++] = num;
                } else {
                    onenums[cntone++] = num;
                }
            }
            int cnt = 0;
            for (int j = 0; j < cntzero; j++) {
                nums[cnt++] = zeronums[j];
            }
            for (int j = 0; j < cntone; j++) {
                nums[cnt++] = onenums[j];
            }
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(nums[i]-nums[i-1], res);
        }
        return res;
    }
}