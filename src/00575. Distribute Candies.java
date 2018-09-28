import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        return set.size() > candies.length/2 ? candies.length/2 : set.size();
    }
}