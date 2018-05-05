class Solution {
    public int lengthOfLastWord(String s) {
        if(s.trim().isEmpty())
            return 0;        
        String[] res = s.split(" ");
        return res[res.length -1].length();
    }
}