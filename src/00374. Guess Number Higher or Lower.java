/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (0 == guess(n))
            return n;
        int l = 1;
        int r = n;
        while (l != r) {
            int mid = l + (r-l)/2;
            if (0 == guess(mid))
                return mid;
            else if (1 == guess(mid))
                l = mid+1;
            else 
                r = mid;
        }
        return l;
    }
}