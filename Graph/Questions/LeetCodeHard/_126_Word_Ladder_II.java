package Graph.Questions.LeetCodeHard;

import java.util.*;

//   https://leetcode.com/problems/word-ladder-ii/description/

public class _126_Word_Ladder_II {
    class Solution {
        Map<String, Integer> map;
        List<List<String>> ans;
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>();
            for(String str: wordList){
                set.add(str);
            }
            Queue<String> queue = new LinkedList<>();
            map = new HashMap<>();
            queue.add(beginWord);
            map.put(beginWord, 1);
            set.remove(beginWord);
            while(!queue.isEmpty()){
                String word = queue.remove();
                int steps = map.get(word);
                if(word.equals(endWord)){
                    break;
                }
                for(int i = 0; i < word.length(); i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        char[] replacedWordArray = word.toCharArray();
                        replacedWordArray[i] = ch;
                        String replacedWord = new String(replacedWordArray);
                        if(set.contains(replacedWord)){
                            queue.add(replacedWord);
                            set.remove(replacedWord);
                            map.put(replacedWord, steps+1);
                        }
                    }
                }
            }
            ans = new ArrayList<>();
            if(map.containsKey(endWord)){
                List<String> seq = new ArrayList<>();
                seq.add(endWord);
                dfs(endWord, seq, beginWord);
            }
            return ans;
        }
        private void dfs(String word, List<String> seq, String beginWord){
            if(word.equals(beginWord)){
                List<String> dup = new ArrayList(seq);
                Collections.reverse(dup);
                ans.add(dup);
                return;
            }
            int steps = map.get(word);
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedWordArray = word.toCharArray();
                    replacedWordArray[i] = ch;
                    String replacedWord = new String(replacedWordArray);
                    if(map.containsKey(replacedWord) && map.get(replacedWord)+1 == steps){
                        seq.add(replacedWord);
                        dfs(replacedWord, seq, beginWord);
                        seq.remove(seq.size()-1);
                    }
                }
            }
        }
    }
}
