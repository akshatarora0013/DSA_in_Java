package Graph.Questions.LeetCodemedium;

import java.util.*;

//  https://leetcode.com/problems/01-matrix/description/

public class _542_01_Matrix {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int[][] distance = new int[mat.length][mat[0].length];
            boolean[][] visited = new boolean[mat.length][mat[0].length];
            Queue<Pair> queue = new LinkedList<>();
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[0].length; j++){
                    if(mat[i][j] == 0){
                        queue.add(new Pair(i, j, 0));
                        visited[i][j] = true;
                    }
                }
            }

            int[] delRow = {1, 0, -1, 0};
            int[] delCol = {0, 1, 0, -1};
            while(!queue.isEmpty()){
                int row = queue.peek().row;
                int col = queue.peek().col;
                int steps = queue.peek().steps;
                queue.remove();

                distance[row][col] = steps;
                for(int i = 0; i < 4; i++){
                    int newRow = row + delRow[i];
                    int newCol = col + delCol[i];

                    if(newRow >= 0 && newCol >= 0 && newRow < mat.length && newCol < mat[0].length && !visited[newRow][newCol]){
                        visited[newRow][newCol] = true;
                        queue.add(new Pair(newRow, newCol, steps+1));
                    }
                }
            }

            return distance;
        }
    }
    class Pair{
        int row;
        int col;
        int steps;
        Pair(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
}
