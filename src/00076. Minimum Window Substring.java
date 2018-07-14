class Solution {
    public String minWindow(String s, String t) {
        int[] cnt1 = new int[126];
        for (int i = 0; i < t.length(); i++) {
            cnt1[t.charAt(i)]++;
        }
        int[] cnt2 = new int[126];
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        boolean isBreak =false;
        while (true) {
            while (!isContainAll(cnt1, cnt2)) {
                if (end >= s.length()) {
                    isBreak = true;
                    break;
                }
                cnt2[s.charAt(end++)]++;
            }
            if (isBreak)
                break;
            if (end - start < minLen) {
                minLen = end-start;
                ans = s.substring(start, end);
            }
            cnt2[s.charAt(start++)]--;
        }
        return  ans;
    }
    private boolean isContainAll(int[] cnt, int[] cnt2) {
        for (int i = 'A'; i <= 'z'; i++) {
            if (cnt[i] > cnt2[i])
                return false;
        }
        return true;
    }
}