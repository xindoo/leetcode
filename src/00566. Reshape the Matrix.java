class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
       if (nums.length * nums[0].length != r * c)
            return nums;
        int result[][] = new int[r][c];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                result[cnt/c][cnt%c] = nums[i][j];
                cnt++;
            }
        }
        return result;
    }
}