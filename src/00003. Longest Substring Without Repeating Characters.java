public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s)
            return 0;
        int len = s.length();
        int start = 0, end = 0;
        int[] cnt = new int[130];
        int ans = 0;
        while (end < len) {
            while (cnt[s.charAt(end)] > 0 && start < len) {
                cnt[s.charAt(start)]--;
                start++;
            }
            while (end < len && cnt[s.charAt(end)] == 0) {
                cnt[s.charAt(end)]++;
                end++;
            }
            if (end - start > ans)
                ans = end - start;
        }
        return ans;
    }
}