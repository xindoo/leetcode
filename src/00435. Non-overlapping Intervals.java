/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        int count = 0, preEnd = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < preEnd)
                count++;
            else
                preEnd = intervals[i].end;
        }
        return count;
    }
}