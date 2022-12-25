class Solution {
    public int captureForts(int[] forts) {        

        int ans = 0;
        int n = forts.length;
        
        for(int i = 0;i< n;i++){
            
            if(forts[i] == 1){
                for(int j=i+1;j<n;j++){
                    
                   if(forts[j]==-1){
                        ans=Math.max(ans,j-i-1);
                        break;
                    }
                    else if(forts[j]==1){
                        break;
               }
            }
            
        }
        
            if(forts[i] == -1){
                for(int j=i+1;j<n;j++){
                    
                    if(forts[j] == 1){
                        ans = Math.max(ans,j-i-1);
                        break;
                    }
                    else if(forts[j] == -1){
                        break;
                    }
                }
            }    
    }
        
        return ans;
        
}

}