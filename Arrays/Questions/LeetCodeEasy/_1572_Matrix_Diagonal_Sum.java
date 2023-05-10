package Arrays.Questions.LeetCodeEasy;

//   https://leetcode.com/problems/matrix-diagonal-sum/description/

public class _1572_Matrix_Diagonal_Sum {
    class Solution {
        public int diagonalSum(int[][] mat) {
            int sum = 0;
            {
                int i = 0;
                int j = 0;
                while(i != mat.length){
                    sum = sum + mat[i][j];
                    sum = sum + mat[i][mat.length - 1 -j];
                    i++;
                    j++;
                }
            }

            if(mat.length %  2 == 0){
                return sum;
            }
            else{
                sum = sum - mat[mat.length/2][mat.length/2];
                return sum;
            }
        }
    }
}
