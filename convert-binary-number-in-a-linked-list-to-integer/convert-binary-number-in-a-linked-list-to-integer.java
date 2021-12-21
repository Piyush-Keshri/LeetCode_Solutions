
class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            ans = 2*ans + temp.val;
            temp = temp.next;
        }
        return ans;
    }
}