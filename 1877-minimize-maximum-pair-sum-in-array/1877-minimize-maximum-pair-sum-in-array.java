class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxsum = 0;
        
        int st = 0;
        int end = nums.length-1;
        
        while(st<=end){
            
            int sum = nums[st]+nums[end];
            maxsum = Math.max(sum,maxsum);
            st++;
            end--;
        }
        
        return maxsum;
    }
}