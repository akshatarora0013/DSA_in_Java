package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/

public class _2074_Reverse_Nodes_in_Even_Length_Groups {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            int group = 1;
            int count = 0;
            ListNode temp = head;
            ListNode last = null;
            ListNode first = null;
            while(temp != null){
                count++;
                if(count == group){
                    if(group % 2 == 0){
                        ListNode end = temp.next;
                        ListNode current = first;
                        ListNode Next = null;
                        ListNode prev = temp.next;
                        while(current != end) {
                            Next = current.next;
                            current.next = prev;
                            prev = current;
                            current = Next;
                        }
                        last.next = prev;
                        temp = first;
                    }
                    last = temp;
                    first = temp.next;
                    count = 0;
                    group++;
                }
                temp = temp.next;
            }
            if(count > 0 && count % 2 == 0){
                ListNode current = first;
                ListNode Next = null;
                ListNode prev = temp;
                while(current != null) {
                    Next = current.next;
                    current.next = prev;
                    prev = current;
                    current = Next;
                }
                last.next = prev;
            }
            return head;
        }
    }
}
