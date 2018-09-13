/**
 * 两个数的汉明距离就是两个数异或结果二进制里1的个数, 10^4个数,如果俩俩异或求汉明距离O(n^2)
 * 的时间复杂度, 明显会超时. 我们换个思路, 既然汉明距离只和没个二进制位有关, 我们就按位计算,
 * 比如n个数里, 第1位总共有m个1, 那么只考虑第一位, 总共能产生的汉明距离就是 (n-m)*m, 我们再
 * 把2,3,4 等其他位按同样的方法算出来即可.  
 */
class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num&(1<<i)) != 0) {
                    cnt[i]++;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += (nums.length-cnt[i])*cnt[i];
        }
        return sum;
    }
}