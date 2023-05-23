package Arrays_Searching_sorting.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/pascals-triangle/description/

public class _118_Pascal_s_Triangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list= new ArrayList<>();
            list.add(new ArrayList<>());
            list.get(0).add(1);
            if(numRows == 1){
                return list;
            }
            list.add(new ArrayList<>());
            list.get(1).add(1);
            list.get(1).add(1);
            for(int i = 2; i < numRows; i++){
                list.add(new ArrayList<>());
                list.get(i).add(1);
                List<Integer> temp = list.get(i-1);
                for(int j = 0; j < temp.size()-1; j++){
                    int newVal = temp.get(j) + temp.get(j+1);
                    list.get(i).add(newVal);
                }
                list.get(i).add(1);
            }

            return list;
        }
    }
}
