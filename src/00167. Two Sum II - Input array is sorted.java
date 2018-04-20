class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        int[] index = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum  == target) {
                index[0] = l+1;
                index[1] = r+1;
                return index;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return index;
    }
}