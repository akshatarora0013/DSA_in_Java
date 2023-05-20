package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/next-greater-element-iii/description/

public class _556_Next_Greater_Element_III {
    class Solution {
        public int nextGreaterElement(int n) {
            char[] arr = (Integer.toString(n)).toCharArray();

            int i = arr.length-2;
            StringBuilder ans = new StringBuilder();
            while(i >= 0 && arr[i] >= arr[i+1]){
                i--;
            }
            if(i == -1){
                return -1;
            }
            int k = arr.length-1;
            while(arr[k] <= arr[i]){
                k--;
            }
            char temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;

            for(int j = 0; j <= i; j++){
                ans.append(arr[j]);
            }
            for(int j = arr.length-1; j > i; j--){
                ans.append(arr[j]);
            }
            long ans_ = Long.parseLong(ans.toString());
            if(ans_ > Integer.MAX_VALUE){
                return -1;
            }
            return (int)ans_;
        }
    }
}
