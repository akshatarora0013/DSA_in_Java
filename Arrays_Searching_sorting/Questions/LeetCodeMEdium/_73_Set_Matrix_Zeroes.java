package Arrays_Searching_sorting.Questions.LeetCodeMEdium;

//   https://leetcode.com/problems/set-matrix-zeroes/description/

public class _73_Set_Matrix_Zeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean[][] processed =new boolean[matrix.length][matrix[0].length];
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    if(matrix[i][j] == 0){
                        processed[i][j] = true;
                    }
                }
            }
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[0].length; j++){
                    if(processed[i][j]){
                        int a = 0;
                        while(a<matrix[0].length){
                            matrix[i][a] = 0;
                            a++;
                        }
                        int b = 0;
                        while(b < matrix.length){
                            matrix[b][j] = 0;
                            b++;
                        }
                    }
                }
            }
        }
    }
}
