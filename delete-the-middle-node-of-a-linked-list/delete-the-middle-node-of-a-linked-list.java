class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return null;
        }
        
        ListNode temp = head;
        ListNode mid = getMiddle(head);
        while(temp.next!=mid)
        {
            temp = temp.next;
        }
        temp.next = mid.next;
        return head;
    }
    
    public ListNode getMiddle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}