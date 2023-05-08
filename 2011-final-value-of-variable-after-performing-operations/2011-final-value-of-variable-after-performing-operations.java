class Solution {
    public int finalValueAfterOperations(String[] operations) {
      int ans = 0;
        
        for(int i=0;i<operations.length;i++){
            
            String str = operations[i];
            if(str.equals("++X") || str.equals("X++")){
                ans+=1;
            }
            else 
            ans-=1;
            
        }
        return ans;
        
    }
}