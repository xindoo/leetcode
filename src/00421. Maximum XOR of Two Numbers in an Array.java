import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 这道题用两层的循环其实就可以找到异或最大的两个数，时间复杂度O(n^2)。题目里问是有O(n)的解法？
 * 这么问了，想都不用想，肯定有啊！ 先来思考下，我们从一堆数中选两个数出来异或最大，这个最大值最
 * 高位的1（比如在x位），那么肯定在数组中有两个数，x位分别为0和1。我们就从最高位到最低位开始寻找，
 * 对于第i位，看看是不是在数组里有两个数第i位分别0和1，而不是11或者00，如果有最大异或和的第i位肯
 * 定是1，没有肯定是0，最重要的1点，我们在算i位的时候，找到的两个数的异或值等于我们已经算出来的位
 * 置，代码如下。
 */

class Solution {
    public int findMaximumXOR(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int xor = 0;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            xor = (1<<i)|xor;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                set.add(xor&nums[j]);
            }
            int tmp = max|(1<<i);
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                int x = iterator.next();
                if (set.contains(x^tmp)) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}}