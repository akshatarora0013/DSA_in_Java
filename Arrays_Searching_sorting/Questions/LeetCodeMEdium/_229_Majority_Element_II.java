package Arrays_Searching_sorting.Questions.LeetCodeMEdium;
import java.util.*;

//  https://leetcode.com/problems/majority-element-ii/description/

public class _229_Majority_Element_II {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i: nums){
                if(map.containsKey(i)){
                    map.put(i, map.get(i)+1);
                }
                else{
                    map.put(i, 1);
                }
            }
            List<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(entry.getValue() > nums.length/3){
                    list.add(entry.getKey());
                }
            }
            return list;
        }
    }
}
