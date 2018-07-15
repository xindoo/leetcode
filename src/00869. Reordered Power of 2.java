class Solution {
    public boolean reorderedPowerOf2(int N) {
        if (N == 1)
            return true;
        int num = 2;
        while (num <= 1000000000) {
            if (isSame(num, N)) {
                return true;
            }
            num = num<<1;
        }
        return false;
    }
    private boolean isSame(int x, int y) {
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        while (x != 0) {
            cnt1[x%10]++;
            x /= 10;
        }
        while (y != 0) {
            cnt2[y%10]++;
            y /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (cnt1[i] != cnt2[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reorderedPowerOf2(10));
    }
}