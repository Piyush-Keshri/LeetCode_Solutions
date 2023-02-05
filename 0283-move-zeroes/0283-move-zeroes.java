class Solution {
    public void moveZeroes(int[] nums) {
        int indx = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            
            if(nums[i]!=0){
                nums[indx] = nums[i];
                indx++;
            }
        }
        
        for(int i= indx;i<n;i++){
            
            nums[i] = 0;
        }
        
    }
}