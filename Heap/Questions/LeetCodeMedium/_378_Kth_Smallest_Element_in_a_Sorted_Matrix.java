package Heap.Questions.LeetCodeMedium;

import java.util.*;

//   https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix.length; j++){
                    if(queue.size() < k){
                        queue.add(matrix[i][j]);
                    }
                    else{
                        if(queue.peek() > matrix[i][j]){
                            queue.remove();
                            queue.add(matrix[i][j]);
                        }
                    }
                }
            }
            return queue.peek();
        }
    }
}
