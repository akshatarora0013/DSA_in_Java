package LinkedList.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/remove-linked-list-elements/description/

public class _203_Remove_Linked_List_Elements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode node = new ListNode();
            if(head == null){
                return head;
            }
            node = head;
            ListNode prev = null;
            while(node != null){
                if(node.val == val && node == head){
                    head = head.next;
                    node = head;
                    continue;
                }
                if(node.val == val){
                    prev.next = node.next;
                    node = node.next;
                }
                else{
                    prev = node;
                    node = node.next;
                }
            }
            return head;
        }
    }
}
