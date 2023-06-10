package Hashing.Questions.LeetCodeEasy;
import java.util.*;

//  https://leetcode.com/problems/design-hashset/description/

public class _705_Design_HashSet {
    class MyHashSet {
        LinkedList<Integer>[] bucketList;
        int capacity;
        int initialCapacity;

        public MyHashSet() {
            capacity = 0;
            initialCapacity = 4091;
            this.bucketList = new LinkedList[initialCapacity];
        }

        public void add(int key) {
            if(!contains(key)){
                int index = hashValue(key);
                if(bucketList[index] == null){
                    LinkedList<Integer> ll = new LinkedList<>();
                    ll.add(key);
                    bucketList[index] = ll;
                }
                else{
                    LinkedList<Integer> ll = bucketList[index];
                    ll.addLast(key);
                }
                capacity++;
            }
        }

        public void remove(int key) {
            int index = hashValue(key);
            if(bucketList[index] != null){
                bucketList[index].removeFirstOccurrence(key);
            }
        }

        public boolean contains(int key) {
            int index = hashValue(key);
            if(bucketList[index] == null){
                return false;
            }
            else{
                LinkedList<Integer> ll = bucketList[index];
                return ll.contains(key);
            }
        }

        private int hashValue(int key){
            return key%initialCapacity;
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
