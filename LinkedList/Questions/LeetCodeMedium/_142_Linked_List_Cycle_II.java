package LinkedList.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/linked-list-cycle-ii/

public class _142_Linked_List_Cycle_II {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            int length = 0;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    ListNode temp = slow;
                    do{
                        length++;
                        temp = temp.next;
                    }while(temp != slow);
                    break;
                }
            }
            if(length == 0){
                return null;
            }
            ListNode first = head;
            ListNode second = head;
            for(int i = 0; i < length; i++){
                second = second.next;
            }
            while(first != second){
                first = first.next;
                second = second.next;
            }
            return first;
        }
    }
}
