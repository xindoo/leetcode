class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A'] ++;
        }
        for (int i = 0; i < 128; i++) {
            ans += cnt[i]/2*2;
        }
        return ans == s.length()?ans:ans+1;
    }
}