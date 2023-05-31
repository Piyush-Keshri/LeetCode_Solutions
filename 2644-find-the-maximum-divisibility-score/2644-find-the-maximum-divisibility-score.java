class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        int ans = divisors[0];
        int max = 0;
        for(int i=0;i<divisors.length;i++){
            int cnt = 0;
            for(int j=0;j<nums.length;j++){
                
                if(nums[j] % divisors[i] == 0){
                    cnt++;
                }
            }
            if(cnt>max){
                max = cnt;
                ans = divisors[i];
            }
        }
        return ans;
    }
}