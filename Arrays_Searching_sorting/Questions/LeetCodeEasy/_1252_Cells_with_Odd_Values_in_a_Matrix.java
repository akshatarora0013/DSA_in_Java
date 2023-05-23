package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/description/

public class _1252_Cells_with_Odd_Values_in_a_Matrix {
    class Solution {
        public int oddCells(int m, int n, int[][] indices) {
            int[][] matrix = new int[m][n];
            for(int[] arr: indices){
                int row = arr[0];
                int col = arr[1];
                for(int i = 0; i < n; i++){
                    matrix[row][i]++;
                }
                for(int i = 0; i < m; i++){
                    matrix[i][col]++;
                }
            }
            int count = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] %2 != 0){
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
