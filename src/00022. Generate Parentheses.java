public class Solution {
    private List<String> ans = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        String s = "";
        getans(0, n, 0, 0, s);
        return this.ans;
    }
    private void getans(int d, int n, int cntl, int cntr, String s) {
        if (d == n*2) {
            this.ans.add(s);
            return;
        }
        if (cntr > cntl)
            return;
        if (cntl < n)
            getans(d+1, n, cntl+1, cntr, s+'(');
        if (cntl > cntr)
            getans(d+1, n, cntl, cntr+1, s+')');
    }
}