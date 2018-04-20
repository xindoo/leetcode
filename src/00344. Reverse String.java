public class Solution {
    public String reverseString(String s) {
        StringBuffer str = new StringBuffer(s);
        String ans = new String(str.reverse());
        return ans;
    }
}