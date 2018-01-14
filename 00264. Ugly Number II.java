class Solution {
    static private int[] uglynums = new int[1700];
    public Solution() {
        uglynums[1] = 1;
        int s1 = 1, s2 = 1, s3 = 1;
        for (int i = 2; i <= 1690; i++) {
            int num = Math.min(uglynums[s1]*2, Math.min(uglynums[s2]*3, uglynums[s3]*5));
            if (uglynums[s1]*2 == num) {
                uglynums[i] = num;
                s1++;
            }
            if (uglynums[s2]*3 == num) {
                uglynums[i] = num;
                s2++;
            }
            if (uglynums[s3]*5 == num) {
                uglynums[i] = num;
                s3++;
            }
        }
    }

    public int nthUglyNumber(int n) {
        return uglynums[n];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nthUglyNumber(10));
    }
}