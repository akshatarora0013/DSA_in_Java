package Graph.Questions.LeetCodemedium;

import java.util.*;

//   https://leetcode.com/problems/rotting-oranges/description/

public class _994_Rotting_Oranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int[][] visited = new int[grid.length][grid[0].length];
            Queue<Pair> queue = new LinkedList<>();
            int countFresh = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 2){
                        queue.add(new Pair(i, j, 0));
                        visited[i][j] = 2;
                    }
                    if(grid[i][j] == 1){
                        countFresh++;
                    }
                }
            }
            int time = 0;
            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};
            int count = 0;
            while(!queue.isEmpty()){
                int r = queue.peek().row;
                int c = queue.peek().col;
                int t = queue.peek().time;
                time = Math.max(t, time);
                queue.remove();
                for(int i = 0; i < 4; i++){
                    int newrow = r - delRow[i];
                    int newcol = c - delCol[i];
                    if(newrow >= 0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 1){
                        queue.add(new Pair(newrow, newcol, t+1));
                        visited[newrow][newcol] = 2;
                        count++;
                    }
                }
            }
            if(count != countFresh){
                return -1;
            }
            return time;
        }
    }
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
