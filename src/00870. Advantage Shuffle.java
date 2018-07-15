import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private class Pair {
        public int i;
        public int v;
        public Pair(int x, int y) {
            this.i = x;
            this.v = y;
        }
    }
    public int[] advantageCount(int[] A, int[] B) {
        Pair[] pairs = new Pair[B.length];
        for (int i = 0; i < B.length; i++) {
            pairs[i] = new Pair(i, B[i]);
        }
        Arrays.sort(A);
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.v - o2.v;
            }
        });
        int n = A.length;
        int[] res = new int[n];

        for(int ts = 0, tf = n-1, ks = 0, kf = n-1; kf >= ks || tf >= ts; ) {
            if(A[ts] > pairs[ks].v){//比较最慢的马，能赢就赢
                res[pairs[ks].i] = A[ts];
                ts++;
                ks++;
            }
            else if(A[ts] < pairs[ks].v){//不能赢，就用田忌最慢的消耗齐王最快的
                res[pairs[kf].i] = A[ts];
                ts++;
                kf--;
            }

            else if(A[tf] > pairs[kf].v){//比较双方最快的马，能赢就赢
                res[pairs[kf].i] = A[tf];
                tf--;
                kf--;
            }
            else if(A[tf] < pairs[kf].v){//不能赢就用田忌最慢的马消耗齐王最快的马
                res[pairs[kf].i] = A[ts];
                ts++;
                kf--;
            }
            else if(A[ts] < pairs[kf].v){//拿田忌最慢的和齐王最快的比，如果慢，就消耗
                res[pairs[kf].i] = A[ts];
                ts++;
                kf--;
            }
            else{//如果一样，后边都是平局
                res[pairs[kf].i] = A[ts];
                ts++;
                kf--;
            }

        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11});
    }
}