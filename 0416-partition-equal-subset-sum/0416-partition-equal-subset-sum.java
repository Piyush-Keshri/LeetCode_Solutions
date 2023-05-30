class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int s=0;
        for(int x:arr){
            s+=x;
        }
        if(s%2 != 0) return false;
        
        boolean[][] dp = new boolean[n][(s/2)+1];
        
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        
        if(arr[0] <= s/2) dp[0][arr[0]] = true;
        
        for(int i=1;i<n;i++){
            
            for(int j=1;j<=s/2;j++){
                
                boolean nt = dp[i-1][j];
                boolean tk = false;
                
                if(arr[i] <= j){
                    tk = dp[i-1][j-arr[i]];
                }
                dp[i][j] = nt||tk;
            }
            
        }
        return dp[n-1][s/2];
    }
    
}










