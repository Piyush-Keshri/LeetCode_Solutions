
class Solution {
    public ListNode reverseBetween(ListNode head, int start, int end) {
        
        if(head == null||start == end )
        {
            return head;
        }
        
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        
        ListNode nodeBeforeSublist = dummyHead;
        int pos = 1;
        while(pos<start)
        {
            nodeBeforeSublist = nodeBeforeSublist.next;
            pos++;
        }
        ListNode workingPtr = nodeBeforeSublist.next;
        while(start<end)
        {
            ListNode nodeToBeExtracted = workingPtr.next;
            workingPtr.next = nodeToBeExtracted.next;
            nodeToBeExtracted.next = nodeBeforeSublist.next;
            nodeBeforeSublist.next = nodeToBeExtracted;
            start++;
        }
        return dummyHead.next;
    }
}