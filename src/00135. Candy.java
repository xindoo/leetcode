import java.util.Arrays;

/**
 * 虽然这道题属于hard级别, 让人不禁往复杂想了, 其实这道题最多数据medium题, 用贪心的思路就可以解决.  
 * 首先保证每个孩子都有一个糖果, 然后从前往后,保证如果每个孩子如果比左边的rating高,就获得比左边孩子
 * 多的糖果, 然后从后往前, 保证每个孩子如果rating比右边高就获得比右边多的糖果数. 
 */
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                arr[i] = arr[i-1]+1;
            }
        }
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && arr[i] <= arr[i+1]) {
                arr[i] = arr[i+1]+1;
            }
        }
        return Arrays.stream(arr).sum();
    }
}