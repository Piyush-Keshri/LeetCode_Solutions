class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int cand = 0;
        
        for(int num : nums){
            
            if(count == 0){
                cand = num;
            }
            if(num == cand){
                count++;
            }
            else{
                count--;
            }
        }
        return cand;
    }
}