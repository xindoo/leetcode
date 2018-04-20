class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < 1<<length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if ((i & (1<<j)) != 0) {
                    tempList.add(nums[j]);
                }
            }
            result.add(tempList);
        }
        return result;
    }
}