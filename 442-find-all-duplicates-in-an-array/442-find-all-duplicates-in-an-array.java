class Solution {
    public List<Integer> findDuplicates(int[] nums) {
      
        List<Integer> ans = new ArrayList<Integer>();
         int  i =0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        
        for(int j = 0;j< nums.length;j++){
            if(j+1 != nums[j]){
                ans.add(nums[j]);
            }
        }
        return ans;
    }
    
    
    public void swap(int[]nums,int i, int j){
        
        int  temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
}