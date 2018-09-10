import java.util.Stack;

/**
 * 关于选择哪个字符，有个很简单的规律，理解这个规律代码也就不难写了。这道题相当于有3个要求。
 * 1. 最终结果每个字符只出现而且必须出现一次。 
 * 2. 字典序最小。
 * 3，很明显，不能打乱字符出现的顺序。
 * 为了达到要求3，我们可以从前往后去。 为达到要求2，我们可以在满足要求1的前提下尽可能选择最
 * 小的那个字符。so？ 举几个简单的例子就容易理解了， 像题中给出的 bcabc，第一个字符取了a，
 * 如果是 abcdabcd 第一个取a， eeebdf 第一个只能取e。我们在从前往后取的过程中，如果发现当
 * 前这个字符，是重复出现的，那我们可以暂时丢弃，往后取，因为可能有更小的，但是如果发现当前这
 * 个字符不是重复的，为了保证满足条件1，我们不得不保留当前字符，但是在这个字符前，如果有更小
 * 的，可以让最终结果更优，所以在往后遍历的过程中，我们得保留前面最小切为选取的字符。代码里，
 * 我用了used[26]来标识每个字符是否被选取，然后用stack存储了临时结果， 每拿到一个新字符，
 * 如果没用过，就判断它是否能替代栈顶的字符（被替代的未被使用，而且后面还出现过，而且新字符比
 * 栈顶的更小）。最终stack里存储的就是我们想要的结果了。
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        int cnt[] = new int[26];
        boolean used[] = new boolean[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            cnt[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            cnt[c-'a']--;
            if (used[c-'a']) {
                continue;
            }
            while (!stack.empty() && stack.peek() > c && cnt[stack.peek()-'a']> 0) {
                used[stack.pop()-'a'] = false;
            }
            stack.push(c);
            used[c-'a'] = true;
        }
        StringBuffer sb = new StringBuffer();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}