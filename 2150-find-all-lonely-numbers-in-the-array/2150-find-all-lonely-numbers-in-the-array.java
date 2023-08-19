class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> ls = new ArrayList<>();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(map.get(nums[i]) == 1 && !map.containsKey(nums[i]-1) && !map.containsKey(nums[i]+1)){
                ls.add(nums[i]);
            } 
            
        }
        return ls;
    }
}