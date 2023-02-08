class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int count = 0;
        int maxCount = 0;
        int j =-1;
        int n = nums.length;
        
        for(int i =0;i<n;i++){
            
            if(nums[i] == 0){
                count++;
            }
            
            while(count>k){
                j++;
                if(nums[j] == 0){
                    count--;
                }
            }
            int len = i-j;
            maxCount = Math.max(maxCount,len);
        }
        return maxCount;
    }
}