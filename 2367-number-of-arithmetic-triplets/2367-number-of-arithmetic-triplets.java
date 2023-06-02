class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int ans = 0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-1;i++){
           
            int n1 = nums[i];
            
            for(int j=i+1;j<nums.length;j++){
                
                if(n1+diff == nums[j]){
                    
                    for(int k=j+1;k<nums.length;k++){
                        if(n1+diff+diff == nums[k]){
                            ans++;
                        }
                    }
                    
                }
                
            }
            
        }
        return ans;
    }
}