package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//   https://leetcode.com/problems/relative-sort-array/

public class _1122_Relative_Sort_Array {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int index = 0;
            for(int i = 0; i < arr2.length; i++){
                for(int j = index; j < arr1.length; j++){
                    if(arr1[j] == arr2[i]){
                        int temp = arr1[j];
                        arr1[j] = arr1[index];
                        arr1[index] = temp;
                        index++;
                    }
                }
            }
            for (int i = index; i < arr1.length-1; i++) {
                for (int j = index+1; j < arr1.length; j++) {
                    if (arr1[j-1] > arr1[j]){
                        int temp = arr1[j-1];
                        arr1[j-1] = arr1[j];
                        arr1[j] = temp;
                    }
                }
            }
            return arr1;
        }
    }
}
