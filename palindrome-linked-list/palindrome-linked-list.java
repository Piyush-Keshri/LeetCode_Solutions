
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = middleNode(head);
        ListNode secondHead = reverseList(mid);
        ListNode rereverse  =  secondHead;
        
        while(head!= null && secondHead != null)
        {
            if(head.val!=secondHead.val)
            {
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        reverseList(rereverse);
        
        return head == null|| secondHead ==null;    
        
    }
    
    
        public ListNode middleNode(ListNode head)
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
    
    public ListNode reverseList(ListNode head)
    {
        if(head == null)
        {
            return head;
        }
        
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        
        while(pres!= null)
        {
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next!=null)
            {
                next = next.next;
            }
        }
        return prev;
    }
}