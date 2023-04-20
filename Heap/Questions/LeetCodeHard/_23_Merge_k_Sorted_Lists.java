package Heap.Questions.LeetCodeHard;

import java.util.*;

//  https://leetcode.com/problems/merge-k-sorted-lists/description/

public class _23_Merge_k_Sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(ListNode node: lists){
                while(node != null){
                    queue.add(node.val);
                    node = node.next;
                }
            }
            if(queue.isEmpty()){
                return null;
            }
            ListNode node = new ListNode(queue.remove());
            ListNode temp = node;
            while(!queue.isEmpty()){
                temp.next = new ListNode(queue.remove());
                temp = temp.next;
            }
            return node;
        }
    }
}
