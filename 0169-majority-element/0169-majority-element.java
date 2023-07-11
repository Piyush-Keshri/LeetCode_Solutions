class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
            
        }
        
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            
            int val = it.getValue();
            
            if(val > n/2){
                return it.getKey();
            }
            
        }
        return -1;
    }
}