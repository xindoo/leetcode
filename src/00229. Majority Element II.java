## 题意 
　　找出数组中出现超过1/3的数。
## 思路
　　我之前写过一篇相关的博客　
```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return ans;
        int a = nums[0], cnta = 0;  //我用a b分别表示两个不一样的数
        int b = nums[0], cntb = 0;
        for (int num : nums) {
            if (num == a) {
                cnta++;
                continue;
            }
            if (num == b) {
                cntb++;
                continue;
            }
            if (cnta == 0) {
                a = num;
                cnta++;
                continue;
            }
            if (cntb == 0) {
                b = num;
                cntb++;
                continue;
            }
            cnta--;
            cntb--;
        }
        cnta = 0;
        cntb = 0;

        for (int num : nums) {
            if (num == a) {
                cnta++;
            } else if (num == b) {
                cntb++;
            }
        }


        if (cnta > nums.length / 3) {
            ans.add(a);
        }

        if (cntb > nums.length / 3) {
            ans.add(b);
        }

        return ans;
    }
}
```