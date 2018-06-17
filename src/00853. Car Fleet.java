import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    class MyPari {
        int pos;
        int speed;
        double time;
        MyPari(int pos, int speed, int target) {
            this.pos = pos;
            this.speed = speed;
            this.time = 1.0*(target - pos) / speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<MyPari> pairs = new ArrayList<>(speed.length);
        for (int i = 0; i < speed.length; i++) {
            pairs.add(new MyPari(position[i], speed[i], target));
        }
        Collections.sort(pairs, new Comparator<MyPari>() {
            @Override
            public int compare(MyPari o1, MyPari o2) {
                return o2.pos - o1.pos;
            }
        });
        double time = Double.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < speed.length; i++) {
            if (pairs.get(i).time > time) {
                cnt++;
                time = pairs.get(i).time;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.carFleet(10, new int[]{6,8}, new int[]{3,2}));
    }
}