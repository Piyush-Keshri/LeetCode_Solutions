class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for(int i = 0; i<nums.length; i++){ 
            max = Math.max(max, nums[i]);
        }
        int score = 0 ;
        while(k-- >0){
            score += max;
            max+=1;
            
        }
        return score;
    }
}