class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     
        List<Integer> res  = new ArrayList<Integer>();
            int i = 0;
            while(i<nums.length){
                int correct = nums[i]-1;
                
                if(nums[i]!=nums[correct]){
                    swap(nums,i,correct);
                }
                else{
                    i++;
                }
            }
          for(int j=0;j<nums.length;j++)
            {
                if(nums[j]!=j+1)
                {
                    res.add(j+1);
                }
            }
            
        return res;
    }
    
    public void swap(int[]nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    
}