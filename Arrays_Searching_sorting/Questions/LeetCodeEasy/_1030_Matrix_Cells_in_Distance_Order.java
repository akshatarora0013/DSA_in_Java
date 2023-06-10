package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//   https://leetcode.com/problems/matrix-cells-in-distance-order/description/

public class _1030_Matrix_Cells_in_Distance_Order {
    class Solution {
        public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
            int[][] result = new int[rows*cols][2];
            int k = 0;
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    result[k][0] = i;
                    result[k][1] = j;
                    k++;
                }
            }
            Arrays.sort(result, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    int d1 = (int)Math.abs(a[0]-rCenter) + (int)Math.abs(a[1]-cCenter);
                    int d2 = (int)Math.abs(b[0]-rCenter) + (int)Math.abs(b[1]-cCenter);
                    if(d1 > d2) return 1;
                    else if(d1 < d2) return -1;
                    else return 0;
                }
            });

            return result;
        }
    }
}
