class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        
        
        for(int i = 0 ;i<nums.length-2;i++){
            
            int lo = i+1;
            int hi = nums.length-1;
            
            while(lo<hi){
                
                int currSum = nums[i] + nums[lo] + nums[hi];
                
                if(Math.abs(currSum - target) < Math.abs(closest - target)){
                    
                    closest = currSum;
                    
                }
                if(currSum > target) hi--;
                else lo++;
                
            }
            
        }
        return closest;
    }
}