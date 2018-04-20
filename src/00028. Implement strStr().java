class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        if (0 == needle.length())
            return 0;
        for (int i = 0; i < haystack.length() - needle.length()+1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (needle.length() - 1 == j)
                    return i;
            }
        }
        return -1;
    }
}