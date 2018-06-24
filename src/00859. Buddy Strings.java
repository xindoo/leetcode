class Solution {
    public boolean buddyStrings(String A, String B) {
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        StringBuffer sa = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < A.length(); i++) {
            cntA[A.charAt(i)-'a']++;
            cntB[B.charAt(i)-'a']++;
            if (A.charAt(i) != B.charAt(i)) {
                sa.append(A.charAt(i));
                sb.append(B.charAt(i));
            }
        }
        if (sa.length() == sb.length() && sa.length() == 2 && sb.toString().equals(sa.reverse().toString()))
            return true;
        if (!sb.toString().equals(sa.reverse().toString()))
            return false;
        for (int i = 0; i < 26; i++) {
            if (cntA[i] > 1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.buddyStrings("ab", "ba");
    }
}