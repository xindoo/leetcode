class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                int a = nums[i];
                nums[i] = 0;
                while (a != 0 && nums[a-1] != a) {
                    int tmp = nums[a-1];
                    nums[a-1] = a;
                    a = tmp;
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]) {
                res.add(i+1);
            }
        }
        return res;
    }
}