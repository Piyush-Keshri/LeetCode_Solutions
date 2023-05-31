class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int m = nums[nums.length-1];
        int score = 0 ;
        while(k-- >0){
            score += m;
            m+=1;
            
        }
        return score;
    }
}