/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode meet=head;
        if(head==null)return null;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }
        if(fast!=null&&fast.next!=null)
        meet=fast;
        else return null;
        slow=head;
        while(meet!=slow){
            meet=meet.next;
            slow=slow.next;
        }
        return meet;

    }
}