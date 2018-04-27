class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0)
            return 0;
        int cnt = 0;
        int maxcnt = 0;
        if (1 == nums[0]) {
            cnt++;
            maxcnt++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (1 == nums[i]) {
                if (1 == nums[i-1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxcnt = Math.max(maxcnt,cnt);
            }
        }
        return maxcnt;
    }
}