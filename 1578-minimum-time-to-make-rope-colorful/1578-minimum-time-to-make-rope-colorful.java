class Solution {
    public int minCost(String colors, int[] neededTime) {
       
        int totalTime = 0;
        int i = 0;
        int j = 0;
        
        while(i<neededTime.length && j<neededTime.length){
            
            int curMax = 0;
            int curTime = 0;
            
            while(j<neededTime.length && colors.charAt(i) == colors.charAt(j)){
                
                curTime+=neededTime[j];
                curMax = Math.max(curMax,neededTime[j]); 
                j++;
            }
            i=j;
            totalTime += curTime - curMax;
        }
        
        return totalTime;
        
    }
}