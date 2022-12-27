class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = capacity.length;
        int ans = 0;
        
        int[] rockDiff = new int[n];
        
        for(int i = 0;i<n;i++){
            
            rockDiff[i] = capacity[i] - rocks[i]; 
        }
        Arrays.sort(rockDiff);
        
        for(int i =0;i<n;i++){
            
            if(additionalRocks >= rockDiff[i]){
                additionalRocks -= rockDiff[i];
                ans++;
            }
            
            else{
                break;
            }
        }
        return ans;
    }
}