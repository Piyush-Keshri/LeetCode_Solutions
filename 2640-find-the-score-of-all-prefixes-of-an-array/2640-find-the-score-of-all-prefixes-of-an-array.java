class Solution {
    public long[] findPrefixScore(int[] nums) {
        
        long[] conv = new long[nums.length];
        int max = 0;
        
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            conv[i] = nums[i]+max;
        }
        
        for(int i=1;i<nums.length;i++){
            
            conv[i] = conv[i-1]+conv[i];
            
        }
        return conv;
    }
}