package Arrays.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/add-to-array-form-of-integer/

public class _989_Add_to_Array_Form_of_Integer {
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = num.length-1; i > 0; i--){
                int n = num[i];
                n = n + k%10;
                if(n > 9){
                    list.add(0 , n%10);
                    num[i-1] += n/10;
                }
                else{
                    list.add(0 , n);
                }
                k = k/10;
            }
            num[0] = num[0] + k;
            while(num[0] > 0){
                list.add(0 , num[0]%10);
                num[0] = num[0]/10;
            }
            return list;
        }
    }
}
