import java.util.HashMap;
import java.util.Map;

/**
 * 看来别人的解答之后才想明白,这其实是一道贪心题, 因为已经是排好序的数据, 每个数只有两种
 * 情况,要么是一个合法连续子序列的开头,要么不是,否则就不存在满足题目要求的划分了,直接返回
 * false. 代码里我用了freq来保存每个数出现的频次,如果说一个数num是有个合法子序列的开头, 
 * 那么freq[num-1] 肯定是等于0的, 代码里做了下转化, 用next来表示num是不是是多少个数的
 * 后缀, 如果nuxt[num] = 3, 表示前面有3个num-1, 如果next[num] = 0. 表示num无法接到
 * 前面某个合法序列里. 然后我们用贪心算法, 为先构造出一个连续3个数的合法子序列, 如果
 * freq[num+1] freq[num+2] 都有值, 肯定是可以构造出合法序列. 
 *
 * 在我们构造过程中已经用掉了一个num+1 和一个num+2,所以相应的freq要减去1. 当变量的下一
 * 个num时我们可能会发现freq[num] == 0, 那肯定是被前面某个num-1或num-2开头的合法子序列
 * 用掉了. 跳过即可. 然后就看它能不能接到前面某个序列后面. 如果不行就看能不能构造出一个新的
 * 序列, 否则就直接返回false了. 这就是这道题的大概解题思路. 
 *
 */
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        Map<Integer, Integer> next = new HashMap<>();

        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            if (next.getOrDefault(num, 0) > 0) {
                next.put(num, next.get(num) - 1);
                next.put(num+1, next.getOrDefault(num+1,0) + 1);
            } else if (freq.getOrDefault(num+1, 0) > 0 && freq.getOrDefault(num+2, 0) > 0) {
                freq.put(num+1, freq.get(num+1) -1);
                freq.put(num+2, freq.get(num+2) -1);
                next.put(num+3, next.getOrDefault(num+3, 0)+1);
            } else {
                return false;
            }
            freq.put(num, freq.get(num) - 1);
        }
        return true;
    }
}