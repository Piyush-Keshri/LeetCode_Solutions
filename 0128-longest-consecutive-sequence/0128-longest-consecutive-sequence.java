class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int x:nums){
            set.add(x);
        }
        
        int ans = 0;
        
        for(int num : nums){
            
            if(!set.contains(num-1)){
                
                int cnt = 1;
                int curr = num;
                
                while(set.contains(curr+1)){
                    curr +=1;
                    cnt+=1;
                }
                ans = Math.max(cnt,ans);
            }
            
        }
       return ans; 
    }
}