class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int[] ans = new int[nums.length]; 
        int indxe = 0;
        int indxo = 1;
        for(int i = 0;i<nums.length;i++){
            
            if(nums[i]%2 == 0){
                ans[indxe] = nums[i];
                indxe+=2;
            }
            else{
                ans[indxo] = nums[i];
                indxo+=2; 
            }
            
        }
        return ans;
    }
}