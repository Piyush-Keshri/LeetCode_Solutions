
class Solution {
    public ListNode swapPairs(ListNode head) {

        List<ListNode> ls = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            ls.add(temp);
            temp = temp.next;            
        }
        
        int i=0;
        int j=1;
        
        int n = ls.size();
        
        while(j<n){
            
            int t = ls.get(i).val;
            ls.get(i).val= ls.get(j).val;
            ls.get(j).val = t;
            
            i+=2;
            j+=2;
            
        }
        
        return head;
    }
}