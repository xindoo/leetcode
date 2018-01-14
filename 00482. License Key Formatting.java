public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer T = new StringBuffer("");
        int cnt = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (cnt > 0 && cnt % K == 0)
                    T.append("-");
                T.append(S.charAt(i));
                cnt++;
            }
        }
        return T.reverse().toString().toUpperCase();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.licenseKeyFormatting("--a-a-a-a--", 2));
    }
}