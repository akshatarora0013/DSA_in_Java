package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

public class _1721_Swapping_Nodes_in_a_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode node = head;
            int length = 0;
            while (node != null){
                length++;
                node = node.next;
            }
            ListNode start = head;
            ListNode end = head;
            for(int i = 1; i < k; i++){
                start = start.next;
            }
            for(int i = 0; i < length-k; i++){
                end = end.next;
            }
            int temp = start.val;
            start.val = end.val;
            end.val = temp;
            return head;
        }
    }
}
