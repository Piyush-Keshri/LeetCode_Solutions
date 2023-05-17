class Solution {
    public int pairSum(ListNode head) {
 
    List<ListNode> ls = new ArrayList<>();
        
        ListNode temp = head;
        
        while(temp!=null){
            ls.add(temp);
            temp = temp.next;
        }
        
        int i=0;
        int j=ls.size()-1;
        
        int sum = 0;
        int maxsum=0;
        
        while(i<=j){
            
            sum=ls.get(i).val + ls.get(j).val;
            maxsum = Math.max(maxsum,sum);
            i++;
            j--;
        }
        
        return maxsum;
    }
}