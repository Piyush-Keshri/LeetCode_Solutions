
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head == null || head.next == null)
        {
            return head;
        }
        
        ListNode last = head;
        int length = 1;
        
        while(last.next !=null)
        {
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k%length;
        int skip = length-rotations;
        
        ListNode newLast = head;
        while(skip>1)
        {
            newLast = newLast.next;
            skip--;
        }
        head = newLast.next;
        newLast.next = null;
            return head;
    }
}