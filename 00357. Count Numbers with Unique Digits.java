public class Solution {
    private int[] ans = {1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771, 8877691};
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10)
            n = 10;
        return this.ans[n];
    }
}