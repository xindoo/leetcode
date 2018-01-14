public class Solution {
    public int findSubstringInWraproundString(String p) {
        int plen = p.length();
        int ans = 0;
        int curlen = 0;
        int[] subsum = new int[26];
        for (int i = 0; i < plen; i++) {
            if (i > 0 && (p.charAt(i)-p.charAt(i-1) == 1 || p.charAt(i)-p.charAt(i-1) == -25)) {
                curlen += 1;
            }
            else {
                curlen = 1;
            }
            int cur = p.charAt(i) - 'a';
            subsum[cur] = Math.max(subsum[cur], curlen);
        }
        for (int i = 0; i < 26; i++) {
            ans += subsum[i];
        }
        return ans;
    }
}