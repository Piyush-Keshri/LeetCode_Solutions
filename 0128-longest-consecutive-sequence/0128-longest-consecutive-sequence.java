class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int ans = 1;
        int prev = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            
            if(prev+1 == nums[i]){
                cnt++;
            }
            else if(nums[i] != prev){
                cnt = 1;
            }
            
            prev = nums[i];
            ans = Math.max(cnt,ans);
            
        }
        return ans;
    }
}