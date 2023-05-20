package LinkedList.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/lru-cache/description/

public class _146_LRU_Cache {
    class LRUCache {
        private int capacity;
        private int count;
        private Map<Integer, DLL> cache;
        private DLL head;
        private DLL tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;
            cache = new HashMap<>();
            this.head = new DLL();
            this.tail = new DLL();
            head.prev = null;
            head.Next = tail;
            tail.prev = head;
            tail.Next = null;
        }

        public int get(int key) {
            DLL node = cache.get(key);
            if(node == null){
                return -1;
            }
            this.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLL node = cache.get(key);
            if(node == null){
                DLL newNode = new DLL(key, value);
                this.cache.put(key, newNode);
                this.addNode(newNode);
                count++;
                if(this.count > capacity){
                    DLL tail = popTail();
                    this.cache.remove(tail.key);
                    count--;
                }
            }
            else{
                node.value = value;
                this.moveToHead(node);
            }
        }

        class DLL{
            int key;
            int value;
            DLL Next;
            DLL prev;
            DLL(){

            }
            DLL(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
        private void addNode(DLL node){
            node.prev = head;
            node.Next = head.Next;
            head.Next.prev = node;
            head.Next = node;
        }
        private void removeNode(DLL node){
            DLL prev = node.prev;
            DLL Next = node.Next;
            prev.Next = Next;
            Next.prev = prev;
        }
        private void moveToHead(DLL node){
            removeNode(node);
            addNode(node);
        }
        private DLL popTail(){
            DLL node = tail.prev;
            removeNode(node);
            return node;
        }
    }
}
