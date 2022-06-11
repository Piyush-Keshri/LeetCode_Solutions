class Solution {
public int minOperations(int[] nums, int x) {
    int target = -x;
    for(int num: nums) target += num;
    if(target == 0) return nums.length;
    if(target < 0) return -1;
    int left = 0, sum = 0, L = 0;
    for(int right = 0; right < nums.length; right++) {
        sum += nums[right];
        while(sum > target) {
            sum -= nums[left++];
        }
        if(sum == target) {
            L = Math.max(L, right - left + 1);
        }
    }
    return L > 0 ? nums.length - L : -1;
}
}