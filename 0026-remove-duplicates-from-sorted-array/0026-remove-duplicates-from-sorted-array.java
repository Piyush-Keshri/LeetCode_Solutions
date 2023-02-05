class Solution {
    public int removeDuplicates(int[] nums) {
        
        int indx = 0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[indx]!=nums[i]){
                indx++;
                nums[indx] = nums[i];
            }
        }
        return indx+1;
    }
}