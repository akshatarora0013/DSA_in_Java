package Arrays.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

public class _448_Find_All_Numbers_Disappeared_in_an_Array {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            boolean[] exist = new boolean[nums.length+1];
            for(int i = 0; i < nums.length; i++){
                exist[nums[i]] = true;
            }
            for(int i = 1; i < exist.length; i++){
                if(!exist[i]){
                    list.add(i);
                }
            }
            return list;
        }
    }
}
