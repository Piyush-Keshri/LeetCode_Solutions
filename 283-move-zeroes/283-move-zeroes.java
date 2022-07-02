class Solution {
    public void moveZeroes(int[] nums) {

        int[] res = new int[nums.length];
        int j = 0;
        
//         Storing the non-zero values in new array
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                res[j] = nums[i];
                j++;
            }
        }
//          populating the new array with zeros after non-zero values        
        for(int k = res.length; k<nums.length;k++){
            res[k] = 0;
        }
//        copying the new array to given array. 
        for(int p = 0;p<nums.length;p++){
            nums[p] = res[p];
        }
        
    }   
}