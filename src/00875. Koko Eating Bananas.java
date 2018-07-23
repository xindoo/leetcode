class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 1000000000;
        while (l < r) {
            int mid = (l+r)>>1;
            if (!canBeFinished(piles, mid, H)) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    private boolean canBeFinished(int[] piles, int s, int H) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i]/s;
            if (piles[i]%s != 0)
                sum += 1;
            if (sum > H)
                return false;
        }
        return true;
    }
}