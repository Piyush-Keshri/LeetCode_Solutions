class Solution {
    public int[] runningSum(int[] nums) {
        
        int[] ans = new int[nums.length];
        int sum = 0;
        int j = 0;
        
        for(int i:nums){
            sum+=i;
            ans[j] = sum;
            j++;
        }
        return ans;
    }
}