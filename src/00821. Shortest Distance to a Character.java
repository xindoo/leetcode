class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        int pre = -S.length()-1;
        for (int i = 0; i < S.length(); i++) {
            res[i] = S.length()+1;
            if (S.charAt(i) == C) {
                pre = i;
            }
            res[i] = Math.min(res[i], i - pre);
        }
        pre = S.length()*2;
        for (int i = S.length()-1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pre = i;
            }
            res[i] = Math.min(res[i], pre-i);
        }
        return res;
    }
}