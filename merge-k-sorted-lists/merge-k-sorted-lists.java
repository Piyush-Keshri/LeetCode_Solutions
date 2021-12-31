class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        for(ListNode node:lists)
        {
            while(node!=null)
            {
                res.add(node.val);
                node = node.next;
            }
        }
        
        Collections.sort(res);
        
        ListNode head = new ListNode(0);
        ListNode h = head;
        
        for(int i:res)
        {
            ListNode temp = new ListNode(i);
            h.next = temp;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }
}