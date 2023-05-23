package Arrays_Searching_sorting.Questions.LeetCodeMEdium;
import java.util.*;

//  https://leetcode.com/problems/3sum/description/

public class _15_3Sum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < nums.length-2; i++){
                if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                    int start = i+1;
                    int end = nums.length-1;
                    int sum = 0 - nums[i];
                    while(start < end){
                        if(nums[start] + nums[end] == sum){
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[start]);
                            temp.add(nums[end]);
                            list.add(temp);
                            while(start < end && nums[start+1] == nums[start]){
                                start++;
                            }
                            while(start < end && nums[end-1] == nums[end]){
                                end--;
                            }
                            start++;
                            end--;
                        }
                        else if(nums[start] + nums[end] < sum){
                            start++;
                        }
                        else{
                            end--;
                        }
                    }
                }
            }
            return list;
        }
    }
}
