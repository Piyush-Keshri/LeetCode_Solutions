class Solution {
    public int longestAlternatingSubarray(int[] nums, int val) {
        int n=nums.length;
        //if(n<=2 && nums[n-1]%2==0 && nums[n-1]<=threshold) return 1;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i] %2 ==0 && nums[i]<=val){
                int j=i+1;
                while(j < n && nums[j] <= val && (nums[j] % 2 != nums[j - 1] % 2)){
                    j++;
                }
                count=Math.max(count,j-i);
            }
            else continue;
        }
        return count;
    }
}