class Solution {
    public int findDuplicate(int[] nums) {
     int j = 0;
        Arrays.sort(nums);
        for(int i = 1;i<nums.length;i++){
            if(nums[j]==nums[i]){
                return nums[j];
            }
            j++;
        }
        return 0;
    }
}