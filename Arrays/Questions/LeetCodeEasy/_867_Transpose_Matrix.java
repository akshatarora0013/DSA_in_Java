package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/transpose-matrix/

public class _867_Transpose_Matrix {
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int[][] ans = new int[matrix[0].length][matrix.length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    ans[j][i] = matrix[i][j];
                }
            }
            return ans;
        }
    }
}
