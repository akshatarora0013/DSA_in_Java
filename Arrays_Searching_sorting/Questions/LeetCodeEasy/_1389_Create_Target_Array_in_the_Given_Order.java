package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/create-target-array-in-the-given-order/

public class _1389_Create_Target_Array_in_the_Given_Order {
    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                list.add(index[i] , nums[i]);
            }
            int ans[] = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
