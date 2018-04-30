import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() < 1)
            return res;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.start != interval2.start)
                    return interval1.start -  interval2.start;
                return interval1.end -  interval2.end;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval it : intervals) {
            if (it.start <= end) {
                end = Math.max(it.end, end);

            } else {
                res.add(new Interval(start, end));
                start = it.start;
                end = it.end;
            }
        }
        res.add(new Interval(start, end));

        return res;
    }
}