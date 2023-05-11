class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        
        int[][] memo = new int[n+1][m+1];
        
        for(int[] row : memo){
            
            Arrays.fill(row,-1);
        }
        return memoization(n,m,nums1,nums2,memo);
    }
    
    public int memoization(int i,int j,int[] nums1,int[] nums2,int[][] memo)    {   
        
     if(i<=0 || j<=0){
         return 0;
     }   
        
    if(memo[i][j] != -1){
        return memo[i][j];
    }
        
    if(nums1[i-1] == nums2[j-1]){
        
        memo[i][j] = 1 + memoization(i-1,j-1,nums1,nums2,memo);
        
    }
        else{
            memo[i][j] = Math.max(memoization(i-1,j,nums1,nums2,memo),memoization(i,j-1,nums1,nums2,memo));
        }
        return memo[i][j];
    }
}