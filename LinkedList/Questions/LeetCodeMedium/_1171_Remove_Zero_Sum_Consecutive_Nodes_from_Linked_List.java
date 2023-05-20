package LinkedList.Questions.LeetCodeMedium;
import java.util.*;

//  https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list

public class _1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode temp = new ListNode(0);
            ListNode current = temp;
            temp.next = head;
            Map<Integer, ListNode> map = new HashMap<>();
            int prefix = 0;
            while(current != null){
                prefix = prefix + current.val;
                if(map.containsKey(prefix)){
                    current = map.get(prefix).next;
                    int p = prefix + current.val;
                    while(p != prefix){
                        map.remove(p);
                        current = current.next;
                        p = p + current.val;
                    }
                    map.get(prefix).next = current.next;
                }
                else{
                    map.put(prefix, current);
                }
                current = current.next;
            }
            return temp.next;
        }
    }
}
