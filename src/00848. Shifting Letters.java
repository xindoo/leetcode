class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] arr = S.toCharArray();
        for(int i = shifts.length-1; i >= 0; i--) {
            if(i < shifts.length-1) shifts[i] +=  shifts[i+1];
            shifts[i] %= 26;

            arr[i] = (char)((arr[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return new String(arr);
    }
}