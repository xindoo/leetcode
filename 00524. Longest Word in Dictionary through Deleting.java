import java.util.List;

public class Solution {

    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (int i = 0; i < d.size(); i++) {
            String t = d.get(i);
            int j = 0, k = 0;
            while (t.length() >= ans.length() && j != s.length() && k != t.length()) {
                if (s.charAt(j) == t.charAt(k)) {
                    j++;
                    k++;
                    continue;
                }
                else {
                    j++;
                }
                if (s.length() - j < t.length() - k)
                    break;
            }
            if (k == t.length()) {
                if (t.length() > ans.length())
                    ans = t;
                else {
                    if (ans.compareTo(t) > 0)
                        ans = t;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}