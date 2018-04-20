public class NumArray {
    private int[] nums;
    private int[] sum;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            if (0 == i)
                sum[i] = nums[i];
            else
                sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int start = 0;
        if (0 != i)
            start = sum[i-1];
        return sum[j] - start;
    }
}