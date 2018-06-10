class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] lr = new int[seats.length];
        int[] rl = new int[seats.length];
        int lastlr = -1;
        int lastrl = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1)
                lastlr = i;
            lr[i] = lastlr;
            if (seats[seats.length - 1 - i] == 1)
                lastrl = seats.length - 1 - i;
            rl[seats.length - 1 - i] = lastrl;
        }
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1)
                continue;
            if (lr[i] == -1) {
                res = Math.max(res, rl[i] - i);
            } else if (rl[i] == -1) {
                res = Math.max(res, i - lr[i]);
            } else {
                res = Math.max(res, Math.min(rl[i] - i, i - lr[i]));
            }
        }
        return res;
    }
}
