public class Solution {
    private boolean hasCommonLetters(String str1, String str2) {
        int[] a = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            a[str1.charAt(i)-'a'] = 1;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (a[str2.charAt(i)-'a'] == 1) 
                return true;
        }
        return false;
    }
    public int maxProduct(String[] words) {
        int len = words.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (!hasCommonLetters(words[i], words[j]))
                    ans = ans>(words[i].length()*words[j].length())?ans:(words[i].length()*words[j].length());
            }
        }
        return ans;
    }
}