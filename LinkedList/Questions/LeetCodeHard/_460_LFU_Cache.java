package LinkedList.Questions.LeetCodeHard;
import java.util.*;

//  https://leetcode.com/problems/lfu-cache/description/

public class _460_LFU_Cache {
//    class LFUCache {
//        private Map<Integer, Pair<Integer, Integer>> cache;
//        private Map<Integer, LinkedHashSet<Integer>> frequencies;
//        private int minf;
//        private int capacity;
//
//        public LFUCache(int capacity) {
//            cache = new HashMap<>();
//            frequencies = new HashMap<>();
//            minf = 0;
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            Pair<Integer, Integer> frequencyValue = cache.get(key);
//            if(frequencyValue == null){
//                return -1;
//            }
//            int frequency = frequencyValue.getKey();
//            Set<Integer> keys = frequencies.get(frequency);
//            keys.remove(key);
//            if(keys.isEmpty()){
//                frequencies.remove(frequency);
//                if(minf == frequency){
//                    minf++;
//                }
//            }
//            int value = frequencyValue.getValue();
//            insert(key, frequency+1, value);
//            return value;
//        }
//
//        public void put(int key, int value) {
//            if(capacity <= 0){
//                return;
//            }
//            Pair<Integer, Integer> frequencyValue = cache.get(key);
//            if(frequencyValue != null){
//                cache.put(key, new Pair<>(frequencyValue.getKey(), value));
//                get(key);
//                return;
//            }
//            if(capacity == cache.size()){
//                Set<Integer> keys = frequencies.get(minf);
//                int keyToDelete = keys.iterator().next();
//                cache.remove(keyToDelete);
//                keys.remove(keyToDelete);
//                if(keys.isEmpty()){
//                    frequencies.remove(minf);
//                }
//            }
//            minf = 1;
//            insert(key, 1, value);
//        }
//
//        private void insert(int key, int frequency, int value){
//            cache.put(key, new Pair<>(frequency, value));
//            frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
//            frequencies.get(frequency).add(key);
//        }
//    }
}
