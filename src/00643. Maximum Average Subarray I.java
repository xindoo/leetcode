class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double[] sum = new double[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        double maxavg = -1.0* Integer.MAX_VALUE;
        for (int i = k; i < nums.length+1; i++) {
            maxavg = Math.max(maxavg, (sum[i]-sum[i-k])/k);
        }
        return maxavg;
    }
}