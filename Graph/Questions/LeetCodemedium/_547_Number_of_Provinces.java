package Graph.Questions.LeetCodemedium;

//  https://leetcode.com/problems/number-of-provinces/description/

public class _547_Number_of_Provinces {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int count = 0;
            boolean[] visited = new boolean[isConnected.length];
            for(int i = 0; i < visited.length; i++){
                if(!visited[i]){
                    count++;
                    dfs(i, isConnected, visited);
                }
            }
            return count;
        }
        public void dfs(int node, int[][] isConnected, boolean[] visited) {
            visited[node] = true;
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visited[i]) {
                    dfs(i, isConnected, visited);
                }
            }
        }
    }
}
