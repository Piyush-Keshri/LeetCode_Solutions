class Solution {
    public void sortColors(int[] nums) {
        
        int cnt0 = 0;
         int cnt1 = 0;
         int cnt2 = 0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==0)
              cnt0++;  
        
        else if(nums[i]==1)
            cnt1++;
        
            else
            cnt2++;
        }
        
        for(int i=0;i<nums.length;i++){
            nums[i] = 0;
        }
        
        for(int i=cnt0;i<nums.length;i++){
            nums[i] = 1;
        }
        
        for(int i=cnt0+cnt1;i<nums.length;i++){
            nums[i] = 2;
        }
    }
}