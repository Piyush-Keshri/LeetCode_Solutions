class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
      int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans += arr[i];
        }
        
        for(int i=0;i<arr.length;i++){
            
            for(int j=i+1;j<arr.length;j++){
                
                if((j-i+1) %2 == 1){
                    
                    for(int k = i;k<=j;k++){
                        ans+=arr[k];
                    }
                    
                }
                
            }
            
        }
        return ans;
    }
}