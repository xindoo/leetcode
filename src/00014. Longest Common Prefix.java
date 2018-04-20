class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String s = strs[0];
        int maxlen = s.length();
        for (int i = 1; i < strs.length; i++) {
            maxlen = Math.min(strs[i].length(), maxlen);
            for (int j = 0; j < maxlen; j++) {
                if (s.charAt(j) != strs[i].charAt(j)) {
                    maxlen = j;
                    break;
                }
            }
        }
        return s.substring(0, maxlen);
    }
}