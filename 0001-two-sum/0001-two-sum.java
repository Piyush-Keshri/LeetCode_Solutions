class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int[] res= new int[2];
        for(int i=0;i<nums.length;i++){
            int num = target-nums[i];
            if(map.containsKey(num)){
                res[0] = map.get(num);
                res[1] = i;
            }
                map.put(nums[i],i);
            
        }
        return res;
    }
}