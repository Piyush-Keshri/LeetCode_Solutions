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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     
        ArrayList<Integer> res = new ArrayList<>();
        
        while(list1 != null){
            res.add(list1.val);
            list1 = list1.next;
        }
        
        
        while(list2 != null){
            res.add(list2.val);
            list2 = list2.next;
        }
        
        Collections.sort(res);
            
        if(res.size() == 0){
            return null;
        }
        
        ListNode head = new ListNode(res.get(0));
        
        ListNode temp = head;
        
        for(int i=1;i<res.size();i++){
            ListNode ls= new ListNode(res.get(i));
            temp.next = ls;
            temp = temp.next;
        }
        temp.next = null;
        return head;
    
    
    }
}










