/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        
        ListNode ans = new ListNode();
        ListNode dum = ans;
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        while(l1 != null || l2!=null || carry == 1){
            
            int sum = 0;
            
            if(l1!= null){
                sum+=l1.val;
                l1 = l1.next;
            }
            
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            
            ListNode temp = new ListNode(sum%10);
            dum.next = temp;
            dum = dum.next;
            
        }
        return reverse(ans.next);
    }
    
    
   public ListNode reverse(ListNode head){
       
       ListNode prev = null;
       ListNode curr = head;
       
       while(curr != null){
           
           ListNode temp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = temp;
           
       }
       return prev;
   }
    
}