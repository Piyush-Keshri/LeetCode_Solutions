class Solution {
    public int semiOrderedPermutation(int[] nums) {
    int n  = nums.length;
    
        if(nums[0] == 1 && nums[n-1] == n){
            return 0;
        } 
        
    int lasti= 0;
    int firsti = 0;
       
          int cnt = 0;
          
        for(int i=0;i<nums.length;i++){
            
            if(nums[i] == 1){
                firsti = i;
            }
            if(nums[i] == n){
                lasti = i;
            }
        }
        
            
        cnt = firsti + n-lasti-1;
        
        if(firsti >lasti){
            return cnt-1;
        }
        else 
            return cnt;
    }
    
    
}