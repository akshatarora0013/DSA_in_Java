package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/number-of-ways-to-split-a-string/description/

public class _1573_Number_of_Ways_to_Split_a_String {
    class Solution {
        int mod = 1_000_000_007;
        public int numWays(String s) {
            int countOnes = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    countOnes++;
                }
            }
            if(countOnes == 0){
                return (int)((s.length()-2L) * (s.length()-1L)/2 % mod);
            }
            if(countOnes % 3 != 0){
                return 0;
            }
            int onesInEveryCut = countOnes/3;
            long waysOfFirstCut = 0;
            long waysOfSecondCut = 0;
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    count++;
                }
                if(count == onesInEveryCut){
                    waysOfFirstCut++;
                    waysOfFirstCut %= mod;
                }
                if(count == 2 * onesInEveryCut){
                    waysOfSecondCut++;
                    waysOfSecondCut %= mod;
                }
            }
            return (int)((waysOfFirstCut * waysOfSecondCut) % (mod));
        }
    }
}
