package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/merge-in-between-linked-lists/

public class _1669_Merge_In_Between_Linked_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode node = list1;
            for(int i = 1; i < a; i++){
                node = node.next;
            }
            ListNode l1 = node;
            for(int i = 0; i <= b-a+1; i++){
                node = node.next;
            }
            ListNode l1last = node;
            ListNode node2 = list2;
            while(node2.next != null){
                node2 = node2.next;
            }
            ListNode l2last = node2;

            //repositioning
            l1.next = list2;
            l2last.next = l1last;

            return list1;
        }
    }
}
