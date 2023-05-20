package Strings.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/sentence-similarity-iii/description/

public class _1813_Sentence_Similarity_III {
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");

            int size1 = s1.length;
            int size2 = s2.length;

            int f1 = 0;
            int f2 = 0;
            int b1 = size1-1;
            int b2 = size2-1;

            while(size1 != 0 && size2 != 0 && s1[f1].equals(s2[f2])){
                size1--;
                size2--;
                f1++;
                f2++;
            }
            while(size1 != 0 && size2 != 0 && s1[b1].equals(s2[b2])){
                size1--;
                size2--;
                b1--;
                b2--;
            }

            return size1 ==0 || size2 == 0;
        }
    }
}
