package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//   https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

public class _1351_Count_Negative_Numbers_in_a_Sorted_Matrix {
    class Solution {
        public int countNegatives(int[][] grid) {
            int col = grid[0].length - 1;
            int row = 0;
            int count = 0;
            while(col >= 0 && row < grid.length){
                if(grid[row][col] >= 0){
                    row++;
                }
                else if(grid[row][col] < 0){
                    count = count + (grid.length-row);
                    col--;
                }
            }
            return count;
        }
    }
}
