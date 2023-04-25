package Hashing.Questions.LeetCodemedium;

import java.util.*;

//    https://leetcode.com/problems/sort-characters-by-frequency/description/

public class _451_Sort_Characters_By_Frequency {
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            List<Character>[] bucket = new List[s.length() + 1];
            for(Character keys: map.keySet()){
                int frequency = map.get(keys);
                if(bucket[frequency] == null){
                    bucket[frequency] = new ArrayList<>();
                }
                for(int i = 0; i < frequency; i++){
                    bucket[frequency].add(keys);
                }
            }
            String str = "";
            for(int i = bucket.length-1; i >= 0; i--){
                if(bucket[i] != null){
                    for(Character ch : bucket[i]){
                        str = str + ch;
                    }
                }
            }
            return str;
        }
    }
}
