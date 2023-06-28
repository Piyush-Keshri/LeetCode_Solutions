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
    public boolean isPalindrome(ListNode head) {
        
        ArrayList<Integer> ls = new ArrayList<>();
        
        while(head != null){
            ls.add(head.val);
            head = head.next;
        }
        
        int st = 0;
        int end = ls.size()-1;
        
        while(st<=end){
            
            if(ls.get(st) != ls.get(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}