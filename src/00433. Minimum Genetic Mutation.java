## 题意 
　　start基因最少要通过多少次变异才能到end，要求每次变异后的基因在bank里才是有效的。  
## 思路
　　bfs找最短路径  
```java
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;

        Set<String> set = new HashSet<>();
        for(String b: bank) {
            set.add(b);
        }

        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        int ans = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) {
                    return ans;
                }

                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: genes) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            ans++;
        }
        return -1;
    }
}
```