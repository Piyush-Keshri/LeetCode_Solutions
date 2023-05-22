class Solution {
    public int mostFrequentEven(int[] nums) {
     
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 == 0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        
      int ans = -1;
      int freq = -1;
    
    for(int num:map.keySet()){
        
        if(map.get(num) > freq){
            freq = map.get(num);
            ans = num;
        }
        else if(map.get(num) == freq && ans > num){
            ans = num;
        }
        
    }
    return ans;
    }
}