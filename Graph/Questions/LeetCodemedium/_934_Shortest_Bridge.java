package Graph.Questions.LeetCodemedium;
import java.util.*;

//   https://leetcode.com/problems/shortest-bridge/description/

public class _934_Shortest_Bridge {
    class Solution {
        private List<int[]> bfsQueue;
        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};
        public int shortestBridge(int[][] grid) {
            int firstx = -1;
            int firsty = -1;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid.length; j++){
                    if(grid[i][j] == 1){
                        firstx = i;
                        firsty = j;
                        break;
                    }
                }
            }

            bfsQueue = new ArrayList<>();
            dfs(grid, firstx, firsty);

            int distance = 0;
            while(!bfsQueue.isEmpty()){
                List<int[]> newbfs = new ArrayList<>();
                for(int[] pair : bfsQueue){
                    for(int i = 0; i < 4; i++){
                        int x = pair[0]+dRow[i];
                        int y = pair[1]+dCol[i];
                        if(x >= 0 && y >= 0 && x < grid.length && y < grid.length){
                            if(grid[x][y] == 1){
                                return distance;
                            }
                            else if(grid[x][y] == 0){
                                newbfs.add(new int[] {x, y});
                                grid[x][y] = -1;
                            }
                        }
                    }
                }

                distance++;
                bfsQueue = newbfs;
            }
            return distance;
        }

        private void dfs(int[][] grid, int x, int y){
            grid[x][y] = 2;
            bfsQueue.add(new int[] {x, y});
            for(int i = 0; i < 4; i++){
                int currX = x+dRow[i];
                int currY = y+dCol[i];
                if(currX >= 0 && currY >= 0 && currX < grid.length && currY < grid.length && grid[currX][currY] == 1){
                    dfs(grid, currX, currY);
                }
            }
        }
    }
}
