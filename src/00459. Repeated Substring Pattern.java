class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len/2; i++) {
            if (len % i == 0) {
                int j = i;
                while (j < len && s.charAt(j) == s.charAt(j % i)) {
                    j++;
                }
                if (j == len) 
                    return true;
            }
        }
        return false;
    }
}