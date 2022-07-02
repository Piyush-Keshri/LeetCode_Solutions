class Solution {
    public void moveZeroes(int[] nums) {

        int[] res = new int[nums.length];
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                res[j] = nums[i];
                j++;
            }
        }
        for(int k = res.length; k<nums.length;k++){
            res[k] = 0;
        }
        for(int p = 0;p<nums.length;p++){
            nums[p] = res[p];
        }
        
    }   
}