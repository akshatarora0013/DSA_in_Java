package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/partition-list/

public class _86_Partition_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode beforehead = new ListNode();
            ListNode afterhead = new ListNode();
            ListNode before = beforehead;
            ListNode after = afterhead;

            while(head != null){
                if(head.val < x){
                    before.next = head;
                    before = before.next;
                }
                else{
                    after.next = head;
                    after = after.next;
                }
                head = head.next;
            }
            after.next = null;
            before.next = afterhead.next;
            beforehead = beforehead.next;
            return beforehead;
        }
    }
}
