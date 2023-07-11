class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int cnt = 1;
            int curr = nums[i];
            
            for(int j=i+1;j<nums.length;j++){
                
                if(nums[j] == curr){
                    cnt++;
                }
                
            }
            if(cnt>n/3){
                set.add(curr);
            }
            
        }
        return new ArrayList<>(set);
    }
}