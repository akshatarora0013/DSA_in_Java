package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/odd-even-linked-list/description/

public class _328_Odd_Even_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            int index = 1;
            int headVal = head.val;
            ListNode evenHead = new ListNode();
            ListNode oddHead = new ListNode();
            ListNode even = evenHead;
            ListNode odd = oddHead;

            while(head != null){
                if(index % 2 == 0){
                    even.next = head;
                    even = even.next;
                    head = head.next;
                    index++;
                }
                else{
                    odd.next = head;
                    odd = odd.next;
                    head = head.next;
                    index++;
                }
            }
            even.next = null;
            odd.next = null;

            odd.next = evenHead.next;
            return oddHead.next;
        }
    }
}
