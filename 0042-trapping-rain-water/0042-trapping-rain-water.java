class Solution {
    
    public int[] maxEleToLeft(int[] height){
       int n = height.length;
        int[] ans = new int[n];
        ans[0] = height[0];
        
        for(int i=1;i<n;i++){
            
            ans[i] = Math.max(ans[i-1],height[i]);
            
        }
        return ans;
    }
    
    
    public int[] maxEleToRight(int[] height){
       int n = height.length;
        int[] ans = new int[n];
        ans[n-1] = height[n-1];
        
        for(int i=n-2;i>=0;i--){
            
            ans[i] = Math.max(ans[i+1],height[i]);
            
        }
        return ans;
    }
    
    
    public int trap(int[] height) {
        int[] mer = maxEleToRight(height);
        int[] mel = maxEleToLeft(height);
        int n = height.length;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            
            int cap = Math.min(mer[i],mel[i])-height[i];
            ans+=cap;
        }
        return ans;
    
    }
}