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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
       return merge(left,right);
    }
      public  ListNode merge(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode temp = ans ;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                temp.next = list1 ;
                list1 = list1.next ;
                temp = temp.next ;
            } else {
                temp.next = list2 ;
                list2 = list2.next ;
                temp = temp.next ;
            }
        }

        while (list1 != null){
            temp.next = list1 ;
            list1 = list1.next ;
            temp = temp.next ;
        }

        while (list2 != null){
            temp.next = list2 ;
            list2 = list2.next ;
            temp = temp.next ;
        }
          
        
        return ans.next ;
    }
    public ListNode getMid(ListNode head)
    {
        ListNode midPrev = null;
        
        while(head!=null && head.next!=null)
        {
            midPrev = (midPrev == null)? head : midPrev.next;
            head = head.next.next;
            
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    
}