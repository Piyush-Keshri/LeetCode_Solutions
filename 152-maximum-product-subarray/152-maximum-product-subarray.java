class Solution {
    public int maxProduct(int[] nums) {
       int maxprod = nums[0];
       int minprod = nums[0];
       int ans = nums[0];
        int choice1,choice2;
        
        for(int i =1;i<nums.length;i++){
            choice1 = maxprod*nums[i];
            choice2 = minprod*nums[i];
            maxprod = Math.max(nums[i],Math.max(choice1,choice2));
            minprod = Math.min(nums[i],Math.min(choice1,choice2));
            
            ans = Math.max(ans,maxprod);
        }
        return ans;
        
        
    }
}