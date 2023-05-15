
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> ls = new ArrayList<>();
        
        ListNode temp = head;
        
        while(temp!=null){
            ls.add(temp);
            temp=temp.next;
        }
        
        int n = ls.size();
        
        int t = ls.get(k-1).val;
        ls.get(k-1).val = ls.get(n-k).val;
        ls.get(n-k).val = t;
        
        return head;
        
    }
}