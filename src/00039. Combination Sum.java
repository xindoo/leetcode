
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> ans = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList();
        Stack<Integer> stack = new Stack<Integer>();
        helper(candidates, target, stack, 0);
        return ans;
    }
    private void helper(int[] candidates, int remainder, Stack<Integer> stack, int start) {
        if (remainder == 0) {
            List<Integer> list = new ArrayList<Integer>();
            Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            ans.add(list);
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remainder) {
                stack.push(candidates[i]);
                helper(candidates, remainder-candidates[i], stack, i);
                stack.pop();
            }
        }
    }
}