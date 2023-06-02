class Solution {
    public boolean divideArray(int[] nums) {
     
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            
            if(entry.getValue() %2 != 0){
                return false;
            }
            
        }
        return true;
    }
}