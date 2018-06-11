class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return check(start + 1, end, s) || check(start, end - 1, s);
            }
        }
        return true;
    }

    private boolean check(int start, int end, String s){
        while (start < end){
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}