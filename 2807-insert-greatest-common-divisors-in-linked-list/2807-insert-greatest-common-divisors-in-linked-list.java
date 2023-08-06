
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode curr = head;
        
        while(curr!=null && curr.next!=null){
            int g = gcd(curr.val,curr.next.val);
            ListNode node = new ListNode(g);
            
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }
        return head;
    }
    
    public int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
        
    }
    
}