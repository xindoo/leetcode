class NumArray {
    private int[] A;
    private int[] C;

    public NumArray(int[] nums) {
        this.A = new int[nums.length+1];
        this.C = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        i += 1;
        int v = val - A[i];
        A[i] = val;
        while (i < A.length) {
            C[i] += v;
            i += (i&(-i));
        }
    }

    private int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += C[i];
            i -= (i&(-i));
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getSum(j+1) - getSum(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */