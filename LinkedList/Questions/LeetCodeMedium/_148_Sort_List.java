package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/sort-list/

public class _148_Sort_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode mid = middleNode(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            return mergeTwoLists(left , right);

        }
        private ListNode mergeTwoLists(ListNode first, ListNode second) {
            ListNode ans = new ListNode();
            ListNode temp = ans;
            while(first != null && second != null){
                if(first.val <= second.val){
                    temp.next = first;
                    first = first.next;
                    temp = temp.next;
                }
                else{
                    temp.next = second;
                    second = second.next;
                    temp = temp.next;
                }
            }
            while(first != null){
                temp.next = first;
                first = first.next;
                temp = temp.next;
            }
            while(second != null){
                temp.next = second;
                second = second.next;
                temp = temp.next;
            }
            return ans.next;
        }
        private ListNode middleNode(ListNode head) {
            ListNode midPrev = null;
            while (head != null && head.next != null) {
                midPrev = (midPrev == null) ? head : midPrev.next;
                head = head.next.next;
            }
            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;
        }
    }
}
