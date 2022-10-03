class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int totalTime = 0;
        int i = 0 , j= 0 ;
        
        while(i<neededTime.length && j<neededTime.length){
            
            int curTotal = 0,curMax = 0;
            
            while(j<neededTime.length && colors.charAt(i) == colors.charAt(j)){
                
                curTotal += neededTime[j];
                curMax = Math.max(curMax,neededTime[j]);
                j++;
            }
            
            totalTime += curTotal - curMax; 
            i=j;
        }
        return totalTime;
    }
}