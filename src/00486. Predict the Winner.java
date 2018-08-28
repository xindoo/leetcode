class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (null == nums || nums.length == 0) {
            return true;
        }
        int[] score = check(nums, 0, nums.length-1, 0);
        return score[0] >= score[1];
    }
    private int[] check(int[] nums, int l, int r, int turn) {
        int[] nscore = new int[2];
        if (l == r) {
            nscore[turn] += nums[l];
            return nscore;
        }
        int nextTurn = turn^1;
        int[] lscore = check(nums, l+1, r, nextTurn);
        int[] rscore = check(nums, l, r-1, nextTurn);
        if (lscore[turn] + nums[l] >= rscore[turn] + nums[r]) {
            nscore[turn] = lscore[turn] + nums[l];
            nscore[nextTurn] = lscore[nextTurn];
        } else {
            nscore[turn] = rscore[turn] + nums[r];
            nscore[nextTurn] = rscore[nextTurn];
        }
        return nscore;
    }
}