
class Solution {
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
//         Reverse The LinkedList
        ListNode nextNode,prev = null;
        
        while(slow!=null){
            
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        
        ListNode start = head;
        int maxsum = 0;
        while(prev!=null){
            
           maxsum = Math.max(start.val+prev.val,maxsum);
           prev = prev.next;
           start = start.next; 
            
        }
        return maxsum;
    }
}