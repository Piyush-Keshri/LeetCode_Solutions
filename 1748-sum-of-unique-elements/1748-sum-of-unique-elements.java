class Solution {
    public int sumOfUnique(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i:nums){
            
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
            
        }
        int sum=0;
        for(int x:map.keySet()){
            if(map.get(x) == 1)
                sum+=x;
        }
        
        return sum;
    }
}