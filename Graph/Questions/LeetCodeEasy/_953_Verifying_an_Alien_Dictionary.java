package Graph.Questions.LeetCodeEasy;

//    https://leetcode.com/problems/verifying-an-alien-dictionary/description/

public class _953_Verifying_an_Alien_Dictionary {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] orderMap = new int[26];
            for(int i = 0; i < orderMap.length; i++){
                orderMap[order.charAt(i)-'a'] = i;
            }
            for(int i = 0; i < words.length-1; i++){
                for(int j = 0; j < words[i].length(); j++){
                    if(j >= words[i+1].length()){
                        return false;
                    }
                    if(words[i].charAt(j) != words[i+1].charAt(j)){
                        int currentWord = words[i].charAt(j) - 'a';
                        int nextWord = words[i+1].charAt(j) - 'a';
                        if(orderMap[currentWord] > orderMap[nextWord]){
                            return false;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            return true;
        }
    }
}
