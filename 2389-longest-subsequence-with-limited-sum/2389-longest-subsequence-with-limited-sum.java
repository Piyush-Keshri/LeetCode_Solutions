class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        Arrays.sort(nums);
        
        int[] ans = new int[queries.length];
        
        for(int i =0;i<queries.length;i++){
            
            int count = 0;
            int query = queries[i];
            
            for(int num : nums){
                
                if(query >= num){
                    count++;
                    query -= num;
                }
                else
                    break;
            }
            ans[i] = count;
        }
        return ans;
    }
}