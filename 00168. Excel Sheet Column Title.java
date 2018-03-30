class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.append((char)('A'+n%26-1));
            n /= 26;
        }
        return new String(sb.reverse());
    }
}