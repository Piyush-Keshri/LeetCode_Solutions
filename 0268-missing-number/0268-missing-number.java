class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int indx = 0;
        
        while(indx<n){
            
            int correct = nums[indx];
            
            if(nums[indx]<n && nums[indx]!=nums[correct]){
                
                int temp = nums[indx];
                nums[indx] = nums[correct];
                nums[correct] = temp;
                
            }
            else
                indx++;
        }
        
        for(int i =0;i<n;i++){
            if(nums[i]!=i){
                return i;
            }
        }
       return n; 
    }
}