class Solution {
    public int subarraysDivByK(int[] nums, int k) {
      
        int ans = 0;
        
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        int sum=0;
        int rem = 0;
        map.put(0,1);
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            rem = sum%k;
            if(rem<0)
                rem +=k;
            if(map.containsKey(rem)){
                ans+=map.get(rem);
            }
                map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        return ans;
        
    }
}