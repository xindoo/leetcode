class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int lcnt = 0, rcnt = 0;
        int cnts = 0, cnte = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                lcnt++;
            } else if (start.charAt(i) == 'R') {
                rcnt++;
            }
            if (end.charAt(i) == 'L') {
                lcnt--;
            } else if (end.charAt(i) == 'R') {
                rcnt--;
            }
            if (lcnt > 0 || rcnt < 0 || (rcnt > 0 && lcnt < 0))
                return false;
        }
        if (lcnt != 0 || rcnt != 0) {
            return false;
        }
        return true;
    }
}