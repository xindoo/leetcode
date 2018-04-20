class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            if (res2+widths[index] > 100) {
                res1 += 1;
                res2 = widths[index];
            } else {
                res2 += widths[index];
            }
        }
        return new int[]{res1+1, res2};
    }
}