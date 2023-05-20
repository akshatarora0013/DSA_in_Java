package Strings.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/count-items-matching-a-rule/

public class _1773_Count_Items_Matching_a_Rule {
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int value;
            if(ruleKey.equals("type")){
                value = 0;
            }
            else if(ruleKey.equals("color")){
                value = 1;
            }
            else{
                value = 2;
            }
            int count = 0;
            for(int i = 0; i < items.size(); i++){
                if(ruleValue.equals(items.get(i).get(value))){
                    count++;
                }
            }
            return count;
        }
    }
}
