class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null )
            return false;
        int ps = 0;
        int pt = 0;
        while (ps < s.length() && pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++; pt++;
            } else {
                pt++;
            }
        }
        if (ps == s.length()) {
            return true;
        }
        return false;
    }
}