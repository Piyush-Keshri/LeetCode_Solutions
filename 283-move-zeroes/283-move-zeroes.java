class Solution {
    public void moveZeroes(int[] nums) {
        
        int l = 0;
        int r = 0;
        
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                r++;
            }
            else{
                int t;
                t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
                l++;
                r++;
            }
        }  
    } 
}