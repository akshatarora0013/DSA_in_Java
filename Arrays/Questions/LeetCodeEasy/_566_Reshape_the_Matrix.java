package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/reshape-the-matrix/

public class _566_Reshape_the_Matrix {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if(r*c != mat.length*mat[0].length){
                return mat;
            }
            int[][] arr = new int[r][c];
            int k = 0;
            int l = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    arr[i][j] = mat[k][l];
                    l++;
                    if(l == mat[0].length){
                        l = 0;
                        k++;
                    }
                }
            }
            return arr;
        }
    }
}
