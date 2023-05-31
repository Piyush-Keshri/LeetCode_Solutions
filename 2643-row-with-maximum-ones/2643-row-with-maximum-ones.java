class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m=mat.length;
        int n = mat[0].length;
        int[] ans = new int[]{0,0};
        
        
        for(int i=0;i<m;i++){
            int cnt1 = 0;
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1)
                cnt1++;
            }
            
            if(cnt1>ans[1]){
                ans[0] = i;
                ans[1] = cnt1;
            }
        }
        return ans;
    }
}