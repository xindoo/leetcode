import java.util.List;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom.length() == 1) return true;
        return helper(bottom, 1, "", allowed);
    }
    private boolean helper(String bottom, int i, String s, List<String> allowed) {
        if (i == bottom.length()) {
            return pyramidTransition(s.toString(), allowed);
        }
        for (String str : allowed) {
            if (str.charAt(0) == bottom.charAt(i-1) && str.charAt(1) == bottom.charAt(i)) {
                if (helper(bottom, i + 1, s+str.charAt(2), allowed)) {
                    return true;
                }
            }
        }
        return false;
    }
}