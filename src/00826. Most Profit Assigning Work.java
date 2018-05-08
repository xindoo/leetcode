class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxDifficulty = 0;
        for (int i = 0; i < difficulty.length; i++) {
            maxDifficulty = Math.max(maxDifficulty, difficulty[i]);
        }
        int[] maxProfits = new int[maxDifficulty+1];
        for (int i = 0; i < difficulty.length; i++) {
            maxProfits[difficulty[i]] = Math.max(maxProfits[difficulty[i]], profit[i]);
        }
        for (int i = 1; i <= maxDifficulty; i++) {
            maxProfits[i] = Math.max(maxProfits[i], maxProfits[i-1]);
        }
        int res = 0;
        for (int i = 0; i < worker.length; i++) {
            res += maxProfits[Math.min(worker[i], maxDifficulty)];
        }
        return res;
    }
}