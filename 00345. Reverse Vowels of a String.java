class Solution {
    public String reverseVowels(String s) {
        char[] ss = s.toCharArray();
        int i = 0, j = ss.length-1;
        while (i < j) {
            if (!"aeiouAEIOU".contains(""+ss[i])) {
                i++;
                continue;
            }
            if (!"aeiouAEIUO".contains(""+ss[j])) {
                j--;
                continue;
            }
            char t = ss[i]; ss[i] = ss[j]; ss[j] = t;
            i++; j--; 
        }
        return String.valueOf(ss);
    }
}
