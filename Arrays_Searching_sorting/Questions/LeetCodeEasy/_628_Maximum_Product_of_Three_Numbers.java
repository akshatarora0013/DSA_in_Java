package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/maximum-product-of-three-numbers/
public class _628_Maximum_Product_of_Three_Numbers {
    class Solution {
        public int maximumProduct(int[] nums) {
            int pro = 1;
            if(nums.length == 3){
                for(int i = 1; i <= 3; i++){
                    pro = pro * nums[nums.length-i];
                }
                return pro;
            }
            Arrays.sort(nums);
            if(nums[nums.length-1] < 0){
                for(int i = 1; i <= 3; i++){
                    pro = pro * nums[nums.length-i];
                }
                return pro;
            }
            else{
                int pro1 = 1;
                for(int i = 1; i <= 3; i++){
                    pro1 = pro1 * nums[nums.length-i];
                }
                int pro2 = nums[nums.length-1] * nums[0] * nums[1];
                if(pro1 > pro2){
                    return pro1;
                }
                else{
                    return pro2;
                }
            }
        }
    }
}

