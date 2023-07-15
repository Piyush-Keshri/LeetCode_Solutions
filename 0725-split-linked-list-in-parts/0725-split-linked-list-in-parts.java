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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode[] res = new ListNode[k];
        
        if(head == null){
            return res;
        }
        
        ListNode temp = head;
        int length = 1;
        while(temp.next != null){
            temp = temp.next;
            length+=1;
        }
        
        int size = length/k;
        int extra = length%k;
        
        ListNode prev = null;
        for(int i=0;i<k && head!=null;i++){
            res[i] = head;
            
            int currsize = size;
            if(extra-- > 0){
                currsize+=1;
            }
            
            while(currsize-- > 0){
                prev = head;
                head = head.next;
            }
            prev.next = null;
        }
        return res;
    }
}












