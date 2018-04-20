import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

public class Solution {
    private boolean[] vis = null;
    private int[] nums2;
    private int[] tmp;
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private void getall(int depth) {
        if (depth == vis.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < vis.length; i++) {
                list.add(tmp[i]);
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < vis.length; i++) {
            if (false == vis[i]) {
                vis[i] = true;
                tmp[depth] = nums2[i];
                getall(depth+1);
                vis[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {

        vis = new boolean[nums.length];
        tmp = new int[nums.length];
        nums2 = nums;
        getall(0);
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 2, 3, 4};
        List<List<Integer>> ans = s.permute(a);
        System.out.println(a[0]);
    }
}