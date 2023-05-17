class Solution {
    public int pairSum(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        ListNode nextNode,prev = null;
        
        while(slow != null){
            
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
            
        }
        ListNode start = head;
        int maxsum = 0;
        while(prev!=null){
            
            maxsum = Math.max(maxsum,prev.val+start.val);
            prev = prev.next;
            start = start.next;
        }
        return maxsum;
    }
}