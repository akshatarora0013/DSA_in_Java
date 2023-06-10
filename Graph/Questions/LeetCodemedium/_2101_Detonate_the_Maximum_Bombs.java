package Graph.Questions.LeetCodemedium;
import java.util.*;

//  https://leetcode.com/problems/detonate-the-maximum-bombs/description/

public class _2101_Detonate_the_Maximum_Bombs {
    class Solution {
        public int maximumDetonation(int[][] bombs) {
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i < bombs.length; i++){
                graph.add(new ArrayList<>());
                for(int j = 0; j < bombs.length; j++){
                    if(i != j){
                        long x1 = bombs[i][0];
                        long y1 = bombs[i][1];
                        long r = bombs[i][2];
                        long x2 = bombs[j][0];
                        long y2 = bombs[j][1];
                        long distanceSq = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
                        if(distanceSq <= r*r){
                            graph.get(i).add(j);
                        }
                    }
                }
            }

            int ans = Integer.MIN_VALUE;
            for(int i = 0; i < bombs.length; i++){
                int[] c = new int[1];
                boolean[] visited = new boolean[bombs.length];
                dfs(graph, visited, i, c);
                ans = Math.max(c[0], ans);
            }

            return ans;
        }

        private void dfs(List<List<Integer>> graph, boolean[] visited, int i, int[] c){
            visited[i] = true;
            c[0]++;
            for(int j: graph.get(i)){
                if(!visited[j]){
                    dfs(graph, visited, j, c);
                }
            }
        }
    }
}
