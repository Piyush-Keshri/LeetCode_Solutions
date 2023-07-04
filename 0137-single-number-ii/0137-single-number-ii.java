class Solution {
    public int singleNumber(int[] nums) {
       
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(nums[i])){
                
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
            
        }
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            
            if(it.getValue() == 1){
                return it.getKey();
            }
            
        }
        return -1;
    }
}