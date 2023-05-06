package Graph.Questions.LeetCodeHard;

import java.util.*;

//   https://leetcode.com/problems/word-ladder/description/

public class _127_Word_Ladder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>();
            for(String str: wordList){
                set.add(str);
            }
            set.remove(beginWord);
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(beginWord, 1));
            set.remove(beginWord);
            while(!queue.isEmpty()){
                String word = queue.peek().str;
                int steps = queue.peek().length;
                queue.remove();
                if(word.equals(endWord)){
                    return steps;
                }
                for(int i = 0; i < word.length(); i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        char[] replacedWordArray = word.toCharArray();
                        replacedWordArray[i] = ch;
                        String replacedWord = new String(replacedWordArray);
                        if(set.contains(replacedWord)){
                            set.remove(replacedWord);
                            queue.add(new Pair(replacedWord, steps+1));
                        }
                    }
                }
            }
            return 0;
        }
    }
    class Pair{
        String str;
        int length;
        Pair(String str, int length){
            this.str = str;
            this.length = length;
        }
    }
}
