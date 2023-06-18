class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            
            min = Math.min(nums[i]-nums[i-1],min);
            
        }
        return min;
    }
}