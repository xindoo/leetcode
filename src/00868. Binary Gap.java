class Solution {
    public int binaryGap(int N) {
        String bs = Integer.toBinaryString(N);
        int ans = 0;
        int lasone = -1;
        for (int i = bs.length()-1; i >= 0; i--) {
            if (bs.charAt(i) == '0')
                continue;
            if (lasone == -1) {
                lasone = i;
            } else {
                ans = Math.max(ans, lasone - i);
                lasone = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.binaryGap(0));
    }
}