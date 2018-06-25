class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(char s : S.toCharArray()) {
            if(J.contains(s+"")) count++;
        }
        return count;
    }
}