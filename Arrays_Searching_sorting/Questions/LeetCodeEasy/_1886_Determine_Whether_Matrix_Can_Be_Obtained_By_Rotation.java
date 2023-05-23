package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

public class _1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int n = mat.length;
            int rotations = 4;
            while(rotations > 0){
                int[][] arr = new int[n][n];
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        arr[i][j] = mat[n-1-j][i];
                    }
                }
                int flag = 0;
                for(int i = 0; i < n; i++){
                    if(!Arrays.equals(arr[i] , target[i])){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    mat = arr;
                    rotations--;
                }
                else{
                    return true;
                }
            }
            return false;
        }
    }
}
