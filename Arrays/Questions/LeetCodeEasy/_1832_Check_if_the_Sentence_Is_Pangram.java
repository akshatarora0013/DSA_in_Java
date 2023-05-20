package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class _1832_Check_if_the_Sentence_Is_Pangram {
    class Solution {
        public boolean checkIfPangram(String sentence) {
            boolean[] arr = new boolean[26] ;
            for(int i = 0; i < sentence.length(); i++){
                //    int character = sentence.charAt(i) - 97;
                arr[sentence.charAt(i) - 97] = true;
            }
            for(int i = 0; i < arr.length; i++){
                if(!arr[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
